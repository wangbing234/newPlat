package com.huiju.eep3.empinfo5.read.handler;

import com.google.common.collect.Lists;
import com.huiju.eep3.empinfo5.command.workOrder.DoBatchCommand;
import com.huiju.eep3.empinfo5.event.planOrder.ChangeStatuisToDownEvent;
import com.huiju.eep3.empinfo5.event.workOrder.*;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import com.huiju.eep3.empinfo5.read.repository.PlanOrderEntityRepository;
import com.huiju.eep3.empinfo5.read.repository.WorkOrderEntityRepository;
import com.huiju.framework.common.exceptions.BusinessException;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component
public class WorkOrderEvent {

    @Autowired
    private WorkOrderEntityRepository workOrderEntityRepository;


    @Autowired
    private PlanOrderEntityRepository planOrderEntityRepository;

    /**
     * delete
     */
    @EventHandler
    @Transactional
    public void on(DeleteWorkOrderEvent evt) {
        workOrderEntityRepository.deleteByIdIn(evt.getIds());
    }

    /**
     * edit
     */
    @EventHandler
    public void on(EditWorkOrderEvent evt) {
        WorkOrderEntity materielType = new WorkOrderEntity();
        BeanUtils.copyProperties(evt, materielType);
        workOrderEntityRepository.save(materielType);
    }

    /**
     * add
     */
    @EventHandler
    public void on(AddWorkOrderEvent evt) {
        WorkOrderEntity materielType = new WorkOrderEntity();
        BeanUtils.copyProperties(evt, materielType);
        workOrderEntityRepository.save(materielType);
    }

    /**
     * add
     */
    @EventHandler
    public void on(ChangeStatuisToDownEvent evt) {
        Optional<PlanOrderEntity> planOrderEntityOptional = planOrderEntityRepository.findById(evt.getId());
        planOrderEntityOptional.ifPresent(planOrderEntity ->
                AggregateLifecycle.apply(new WorkOrderDispatchEvent(planOrderEntity))
        );
    }


    /**
     * add
     */
    @EventHandler
    public void on(DoBatchCommand evt) {
        Optional<WorkOrderEntity> planOrderEntityOptional = workOrderEntityRepository.findById(evt.getBatchWorkOrderDTO().getId());
        List<WorkOrderEntity> workOrderEntityList = Lists.newArrayList();
        planOrderEntityOptional.ifPresent(planOrderEntity -> {
            evt.getBatchWorkOrderDTO().getNumber().stream().map(number -> {
                WorkOrderEntity work = new WorkOrderEntity();
                BeanUtils.copyProperties(planOrderEntity, work);
                work.setPlanQty(new BigDecimal(number));
                work.setId(UUID.randomUUID().toString());
                workOrderEntityList.add(work);
                return work;
            });
        });
        AggregateLifecycle.apply(new BatchChangeWorkOrderEvent(workOrderEntityList));
    }


    /**
     * add
     */
    @EventHandler
    public void on(SortEvent evt) {
        List<WorkOrderEntity> workOrderEntityList = workOrderEntityRepository.findByIdIn(evt.getIds());
        if (CollectionUtils.isEmpty(workOrderEntityList)) {
            throw new BusinessException("找不到排序对象");
        }
        for (int i = 0; i < workOrderEntityList.size(); i++) {
            workOrderEntityList.get(i).setSeq(i);
        }
        AggregateLifecycle.apply(new BatchChangeWorkOrderEvent(workOrderEntityList));
    }

    /**
     * add
     */
    @EventHandler
    public void on(ActiveEvent evt) {
        List<WorkOrderEntity> workOrderEntityList = workOrderEntityRepository.findByIdIn(evt.getIds());
        if (CollectionUtils.isEmpty(workOrderEntityList)) {
            throw new BusinessException("找不到激活数据");
        }
        workOrderEntityList.forEach(workOrderEntity -> {
            workOrderEntity.setActive(Boolean.TRUE);
        });
        AggregateLifecycle.apply(new BatchChangeWorkOrderEvent(workOrderEntityList));
    }


    /**
     * add
     */
    @EventHandler
    public void on(FreezeEvent evt) {
        List<WorkOrderEntity> workOrderEntityList = workOrderEntityRepository.findByIdIn(evt.getIds());
        if (CollectionUtils.isEmpty(workOrderEntityList)) {
            throw new BusinessException("找不到排程对象");
        }
        workOrderEntityList.forEach(workOrderEntity -> {
            workOrderEntity.setActive(Boolean.FALSE);
        });
        AggregateLifecycle.apply(new BatchChangeWorkOrderEvent(workOrderEntityList));
    }

    /**
     * add
     */
    @EventHandler
    public void on(ScheduleEvent evt) {
        List<WorkOrderEntity> workOrderEntityList = workOrderEntityRepository.findByIdIn(evt.getIds());
        if (CollectionUtils.isEmpty(workOrderEntityList)) {
            throw new BusinessException("找不到排程对象");
        }
        workOrderEntityList.forEach(workOrderEntity -> {
            Date date = new Date();
            workOrderEntity.setPlanBeginTime(date);
            workOrderEntity.setPlanEndTime(DateUtils.addHours(date, new Random().nextInt(10)));
        });
        AggregateLifecycle.apply(new BatchChangeWorkOrderEvent(workOrderEntityList));
    }


}
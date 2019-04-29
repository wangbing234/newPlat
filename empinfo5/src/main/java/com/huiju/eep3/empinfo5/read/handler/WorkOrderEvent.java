package com.huiju.eep3.empinfo5.read.handler;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.huiju.eep3.empinfo5.event.planOrder.ChangeStatuisToDownEvent;
import com.huiju.eep3.empinfo5.event.workOrder.ActiveEvent;
import com.huiju.eep3.empinfo5.event.workOrder.AddWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.BatchAddWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.BatchChangeWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.DeleteWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.DoBatchWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.EditWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.FreezeEvent;
import com.huiju.eep3.empinfo5.event.workOrder.ScheduleEvent;
import com.huiju.eep3.empinfo5.event.workOrder.SortEvent;
import com.huiju.eep3.empinfo5.event.workOrder.WorkOrderDispatchEvent;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import com.huiju.eep3.empinfo5.read.repository.PlanOrderEntityRepository;
import com.huiju.eep3.empinfo5.read.repository.WorkOrderEntityRepository;
import com.huiju.framework.common.exceptions.BusinessException;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.annotation.EventHandler;
import com.huiju.framework.ddd.annotation.ReadModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ReadModel
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
    public void on(DoBatchWorkOrderEvent evt) {
        Optional<WorkOrderEntity> planOrderEntityOptional = workOrderEntityRepository.findById(evt.getBatchWorkOrderDTO().getId());
        List<WorkOrderEntity> workOrderEntityList = Lists.newArrayList();
        if(planOrderEntityOptional.isPresent()){
            evt.getBatchWorkOrderDTO().getNumber().forEach(number -> {
                WorkOrderEntity work = new WorkOrderEntity();
                BeanUtils.copyProperties(planOrderEntityOptional.get(), work);
                work.setPlanQty(new BigDecimal(number));
                work.setId(null);
                workOrderEntityList.add(work);
            });
        }

        AggregateLifecycle.apply(new BatchAddWorkOrderEvent(workOrderEntityList));
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
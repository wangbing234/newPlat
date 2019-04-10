package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.eep3.empinfo5.command.workOrder.WorkOrderDispatchCommand;
import com.huiju.eep3.empinfo5.event.planOrder.ChangeStatuisToDownEvent;
import com.huiju.eep3.empinfo5.event.workOrder.*;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import com.huiju.eep3.empinfo5.read.repository.PlanOrderEntityRepository;
import com.huiju.eep3.empinfo5.read.repository.WorkOrderEntityRepository;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public void on(ChangeStatuisToDownEvent cmd) {
        Optional<PlanOrderEntity> planOrderEntityOptional = planOrderEntityRepository.findById(cmd.getId());
        planOrderEntityOptional.ifPresent(planOrderEntity ->
                AggregateLifecycle.apply(new WorkOrderDispatchEvent(planOrderEntity))
        );
    }



}
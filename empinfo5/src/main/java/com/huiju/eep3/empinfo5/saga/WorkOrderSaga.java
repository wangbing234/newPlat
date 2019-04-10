package com.huiju.eep3.empinfo5.saga;

import com.google.common.collect.Lists;
import com.huiju.eep3.empinfo5.command.workOrder.AddWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.EditWorkOrderCommand;
import com.huiju.eep3.empinfo5.event.workOrder.WorkOrderDispatchEvent;
import com.huiju.eep3.empinfo5.event.workOrder.WorkOrderSchudleEvent;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import com.huiju.framework.ddd.saga.annotation.SagaEventHandler;
import com.huiju.framework.ddd.saga.annotation.Sagas;
import com.huiju.framework.ddd.saga.annotation.StartSaga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AccountCreatedEvt Saga
 *
 * @author wangkai
 * @since 2018/11/16.
 */
@Slf4j
@Sagas
public class WorkOrderSaga {


    /**
     * 订单下发
     */
    @StartSaga
    @SagaEventHandler
    public List<AddWorkOrderCommand> on(WorkOrderDispatchEvent evt) {
        List<AddWorkOrderCommand> workOrderDispatchCommands = Lists.newArrayList();
        PlanOrderEntity planOrder = evt.getPlanOrderEntity();
        for (int i = 0; i < planOrder.getPlanQty(); i++) {
            AddWorkOrderCommand createOrderByPlanOrderCommand = new AddWorkOrderCommand();
            BeanUtils.copyProperties(planOrder, createOrderByPlanOrderCommand);
            createOrderByPlanOrderCommand.setBatchNumber("1");
            createOrderByPlanOrderCommand.setPlanQty(new BigDecimal(1));
            workOrderDispatchCommands.add(createOrderByPlanOrderCommand);
        }
        return workOrderDispatchCommands;
    }


    /**
     * 订单下发
     */
    @StartSaga
    @SagaEventHandler
    public List<EditWorkOrderCommand> on(WorkOrderSchudleEvent evt) {
        List<WorkOrderEntity> workOrderEntityList = evt.getWorkOrderEntityList();

        return workOrderEntityList.stream().map(workOrderEntity -> {
            EditWorkOrderCommand editWorkOrderCommand = new EditWorkOrderCommand();
            BeanUtils.copyProperties(workOrderEntity, editWorkOrderCommand);
            return editWorkOrderCommand;
        }).collect(Collectors.toList());
    }

}

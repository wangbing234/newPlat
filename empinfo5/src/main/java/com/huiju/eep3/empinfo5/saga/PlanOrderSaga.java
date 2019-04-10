package com.huiju.eep3.empinfo5.saga;

import com.huiju.eep3.empinfo5.event.planOrder.PlanDispatchEvent;
import com.huiju.eep3.empinfo5.command.workOrder.WorkOrderDispatchCommand;
import com.huiju.framework.ddd.saga.annotation.SagaEventHandler;
import com.huiju.framework.ddd.saga.annotation.Sagas;
import com.huiju.framework.ddd.saga.annotation.StartSaga;
import lombok.extern.slf4j.Slf4j;

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
public class PlanOrderSaga {


    /**
     * 订单下发
     */
    @StartSaga
    @SagaEventHandler
    public List<WorkOrderDispatchCommand> on(PlanDispatchEvent evt) {
        return evt.getIds().stream().map(id -> new WorkOrderDispatchCommand(id)).collect(Collectors.toList());
    }






}

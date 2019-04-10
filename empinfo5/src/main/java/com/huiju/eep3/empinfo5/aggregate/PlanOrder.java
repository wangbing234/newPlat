package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.planOrder.PlanCreateCommand;
import com.huiju.eep3.empinfo5.command.planOrder.PlanDeleteCommand;
import com.huiju.eep3.empinfo5.command.planOrder.PlanDispatchCommand;
import com.huiju.eep3.empinfo5.command.planOrder.PlanEditCommand;
import com.huiju.eep3.empinfo5.command.workOrder.WorkOrderDispatchCommand;
import com.huiju.eep3.empinfo5.enums.PlanOrderStatusEnums;
import com.huiju.eep3.empinfo5.event.planOrder.*;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@Slf4j
public class PlanOrder extends SimpleAggregate {
    /**
     * 产品
     */
    private String bmProductAggGid;
    /**
     * 编码
     */
    private String code;

    /**
     * 编码
     */
    private String status;

    /**
     * 工作中心
     */
    private String workCenterGid;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 计划数量
     */
    private Integer planQty;
    /**
     * 计划时间
     */
    private Date planBeginTime;

    /**
     * 订单下发
     */
    @CommandHandler
    public void handler(PlanDispatchCommand cmd) {
        PlanDispatchEvent planDispatchEvent = new PlanDispatchEvent();
        planDispatchEvent.setIds(cmd.getIds());
        AggregateLifecycle.apply(planDispatchEvent);
    }

    /**
     * deletePlan
     */
    @CommandHandler
    public void handler(PlanDeleteCommand cmd) {
        PlanDeleteEvent planEditEvent = new PlanDeleteEvent();
        BeanUtils.copyProperties(cmd, planEditEvent);
        AggregateLifecycle.apply(planEditEvent);
    }

    /**
     * deletePlan
     */
    @CommandHandler
    public void handler(WorkOrderDispatchCommand cmd) {
        ChangeStatuisToDownEvent planEditEvent = new ChangeStatuisToDownEvent();
        planEditEvent.setId(cmd.getId());
        AggregateLifecycle.apply(planEditEvent);
    }

    /**
     * editPlan
     */
    @CommandHandler
    public void handler(PlanEditCommand cmd) {
        PlanEditEvent planEditEvent = new PlanEditEvent();
        BeanUtils.copyProperties(cmd, planEditEvent);
        AggregateLifecycle.apply(planEditEvent);
    }

    /**
     * addPlan
     */
    @CommandHandler
    public void handler(PlanCreateCommand cmd) {
        PlanAddEvent addTypeEvt = new PlanAddEvent();
        BeanUtils.copyProperties(cmd, addTypeEvt);
        addTypeEvt.setId(getAggregateId());
        AggregateLifecycle.apply(addTypeEvt);
    }

    /**
     * PlanAddEvent事件处理
     */
    @EventHandler
    public void on(PlanAddEvent evt) {
        BeanUtils.copyProperties(evt, this);
    }

    @EventHandler
    public void on(ChangeStatuisToDownEvent evt) {
        this.status= PlanOrderStatusEnums.DOWN.name();
    }

    /**
     * PlanEditEvent事件处理
     */
    @EventHandler
    public void on(PlanEditEvent evt) {
        BeanUtils.copyProperties(evt, this);
    }
}
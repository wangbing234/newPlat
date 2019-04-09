package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.planOrder.PlanCreateCommand;
import com.huiju.eep3.empinfo5.command.planOrder.PlanDeleteCommand;
import com.huiju.eep3.empinfo5.command.planOrder.PlanEditCommand;
import com.huiju.eep3.empinfo5.event.planOrder.PlanAddEvent;
import com.huiju.eep3.empinfo5.event.planOrder.PlanDeleteEvent;
import com.huiju.eep3.empinfo5.event.planOrder.PlanEditEvent;
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
     * deletePlan
     */
    @CommandHandler
    public void handler(PlanDeleteCommand cmd) {
        PlanDeleteEvent planEditEvent = new PlanDeleteEvent();
        BeanUtils.copyProperties(cmd, planEditEvent);
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

    /**
     * PlanEditEvent事件处理
     */
    @EventHandler
    public void on(PlanEditEvent evt) {
        BeanUtils.copyProperties(evt, this);
    }
}
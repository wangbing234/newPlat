package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.workOrder.AddWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.DeleteWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.EditWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.ScheduleCommand;
import com.huiju.eep3.empinfo5.event.planOrder.PlanDeleteEvent;
import com.huiju.eep3.empinfo5.event.planOrder.PlanEditEvent;
import com.huiju.eep3.empinfo5.event.workOrder.AddWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.DeleteWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.EditWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.ScheduleEvent;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@Slf4j
public class WorkOrder extends SimpleAggregate {

    /**
     * 工单类别
     */
    private String orderType;
    /**
     * 生产工单来源类型
     */
    private String resourceOrderType;
    /**
     * 合格数量
     */
    private Integer qualifiedQty;
    /**
     * 不合格数量
     */
    private Integer unqualifiedQty;
    /**
     * 废品数量
     */
    private Integer wasteQty;
    /**
     * 生产工单数量
     */
    public BigDecimal planQty;
    /**
     * 批次号\轮次号
     */
    private String batchNumber;
    /**
     * 产品聚合Gid
     */
    private String bmProductAggGid;
    /**
     * 编码
     */
    private String code;

    /**
     * 计划开始时间
     */
    public java.util.Date planBeginTime;

    /**
     * 计划完成时间
     */
    public java.util.Date planEndTime;

    /**
     * deleteWorkOrder
     */
    @CommandHandler
    public void handler(DeleteWorkOrderCommand cmd) {
        DeleteWorkOrderEvent planEditEvent = new DeleteWorkOrderEvent();
        BeanUtils.copyProperties(cmd, planEditEvent);
        AggregateLifecycle.apply(planEditEvent);
    }

    /**
     * editWorkOrder
     */
    @CommandHandler
    public void handler(AddWorkOrderCommand cmd) {
        AddWorkOrderEvent planEditEvent = new AddWorkOrderEvent();
        BeanUtils.copyProperties(cmd, planEditEvent);
        planEditEvent.setId(getAggregateId());
        AggregateLifecycle.apply(planEditEvent);
    }

    /**
     * editWorkOrder
     */
    @CommandHandler
    public void handler(EditWorkOrderCommand cmd) {
        EditWorkOrderEvent planEditEvent = new EditWorkOrderEvent();
        BeanUtils.copyProperties(cmd, planEditEvent);
        AggregateLifecycle.apply(planEditEvent);
    }

    /**
     * 排程
     */
    @CommandHandler
    public void handler(ScheduleCommand cmd) {
        ScheduleEvent scheduleEvent = new ScheduleEvent();
        BeanUtils.copyProperties(cmd, scheduleEvent);
        AggregateLifecycle.apply(scheduleEvent);
    }


    /**
     * AddWorkOrderEvent事件处理
     */
    @EventHandler
    public void on(AddWorkOrderEvent evt) {
    }

    /**
     * EditWorkOrderEvent事件处理
     */
    @EventHandler
    public void on(EditWorkOrderEvent evt) {
    }

    /**
     * DeleteWorkOrderEvent事件处理
     */
    @EventHandler
    public void on(DeleteWorkOrderEvent evt) {
    }
}
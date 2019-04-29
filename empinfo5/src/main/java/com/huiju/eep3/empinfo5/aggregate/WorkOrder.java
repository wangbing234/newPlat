package com.huiju.eep3.empinfo5.aggregate;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.huiju.eep3.empinfo5.command.workOrder.ActiveCommand;
import com.huiju.eep3.empinfo5.command.workOrder.AddWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.BatchCommand;
import com.huiju.eep3.empinfo5.command.workOrder.DeleteWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.DoBatchCommand;
import com.huiju.eep3.empinfo5.command.workOrder.EditWorkOrderCommand;
import com.huiju.eep3.empinfo5.command.workOrder.FreezeCommand;
import com.huiju.eep3.empinfo5.command.workOrder.ScheduleCommand;
import com.huiju.eep3.empinfo5.command.workOrder.SortCommand;
import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.eep3.empinfo5.component.workorder.action.ApsWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.action.CreateWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.action.SortWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.vo.WorkOrderVO;
import com.huiju.eep3.empinfo5.dto.WorkOrderDTO;
import com.huiju.eep3.empinfo5.event.workOrder.ActiveEvent;
import com.huiju.eep3.empinfo5.event.workOrder.AddWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.BatchWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.DeleteWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.DoBatchWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.EditWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.FreezeEvent;
import com.huiju.eep3.empinfo5.event.workOrder.ScheduleEvent;
import com.huiju.eep3.empinfo5.event.workOrder.SortEvent;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import com.huiju.framework.ddd.ime.engine.ImeEngineComponent;
import com.huiju.framework.ddd.ime.engine.ImeEngineHelper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
     * 订单顺序号
     */
    public Integer seq;

    /**
     * 是否激活
     */
    public Boolean active;


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
     * @throws Exception 
     */
    @CommandHandler
    public void handler(AddWorkOrderCommand cmd) throws Exception {
        AddWorkOrderEvent planEditEvent = new AddWorkOrderEvent();
        
        ImeEngineComponent compInstance = new WorkOrderComponent(this.getAggregateId(), cmd.getScene());
        Class actionType = CreateWorkOrderAction.class;
        WorkOrderDTO dto = new WorkOrderDTO();
        dto.setId(this.getAggregateId());
        dto.setCode(cmd.getCode());        
        WorkOrderVO result = (WorkOrderVO) ImeEngineHelper.execute(compInstance, actionType, dto);
        String st = compInstance.getState().getValue();
        
        BeanUtils.copyProperties(cmd, planEditEvent);
        planEditEvent.setId(getAggregateId());
        cmd.setActive(Boolean.TRUE);
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
     * @throws Exception 
     */
    @CommandHandler
    public void handler(ScheduleCommand cmd) throws Exception {
        ScheduleEvent scheduleEvent = new ScheduleEvent();
        for(String id: cmd.getIds()) {
            ImeEngineComponent compInstance = new WorkOrderComponent(id, cmd.getScene());
            Class actionType = ApsWorkOrderAction.class;
            WorkOrderDTO dto = new WorkOrderDTO();
            dto.setId(id);
            WorkOrderVO result = (WorkOrderVO) ImeEngineHelper.execute(compInstance, actionType, dto);
            String st = compInstance.getState().getValue();
        }
        
        BeanUtils.copyProperties(cmd, scheduleEvent);
        AggregateLifecycle.apply(scheduleEvent);
    }

    /**
     * 排程
     * @throws Exception 
     */
    @CommandHandler
    public void handler(SortCommand cmd) throws Exception {
        SortEvent sortEvent = new SortEvent();
        for(String id: cmd.getIds()) {
            ImeEngineComponent compInstance = new WorkOrderComponent(id, cmd.getScene());
            Class actionType = SortWorkOrderAction.class;
            WorkOrderDTO dto = new WorkOrderDTO();
            dto.setId(id);
            WorkOrderVO result = (WorkOrderVO) ImeEngineHelper.execute(compInstance, actionType, dto);
            String st = compInstance.getState().getValue();
        }
        
        BeanUtils.copyProperties(cmd, sortEvent);
        AggregateLifecycle.apply(sortEvent);
    }

    /**
     * 排程
     */
    @CommandHandler
    public void handler(ActiveCommand cmd) {
        ActiveEvent sortEvent = new ActiveEvent();
        BeanUtils.copyProperties(cmd, sortEvent);
        AggregateLifecycle.apply(sortEvent);
    }

    /**
     * 排程
     */
    @CommandHandler
    public void handler(FreezeCommand cmd) {
        FreezeEvent sortEvent = new FreezeEvent();
        BeanUtils.copyProperties(cmd, sortEvent);
        AggregateLifecycle.apply(sortEvent);
    }

    /**
     * 排程
     */
    @CommandHandler
    public void handler(BatchCommand cmd) {
        BatchWorkOrderEvent batchWorkOrderEvent = new BatchWorkOrderEvent();
        BeanUtils.copyProperties(cmd, batchWorkOrderEvent);
        AggregateLifecycle.apply(batchWorkOrderEvent);
    }
    /**
     * 排程
     */
    @CommandHandler
    public void handler(DoBatchCommand cmd) {
        DoBatchWorkOrderEvent batchWorkOrderEvent = new DoBatchWorkOrderEvent();
        BeanUtils.copyProperties(cmd, batchWorkOrderEvent);
        AggregateLifecycle.apply(batchWorkOrderEvent);
    }





    /**
     * AddWorkOrderEvent事件处理
     */
    @EventHandler
    public void on(AddWorkOrderEvent evt) {
        BeanUtils.copyProperties(evt, this);
    }

    /**
     * EditWorkOrderEvent事件处理
     */
    @EventHandler
    public void on(EditWorkOrderEvent evt) {
        BeanUtils.copyProperties(evt, this);
    }

    /**
     * DeleteWorkOrderEvent事件处理
     */
    @EventHandler
    public void on(DeleteWorkOrderEvent evt) {
        AggregateLifecycle.destory();
    }
}
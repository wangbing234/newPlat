package com.huiju.eep3.empinfo5.component.workorder.action;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.component.workorder.plugin.SortWorkOrderCheckAfterActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.plugin.SortWorkOrderCheckPreActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.state.SortWorkOrderState;
import com.huiju.eep3.empinfo5.component.workorder.vo.WorkOrderVO;
import com.huiju.eep3.empinfo5.dto.WorkOrderDTO;
import com.huiju.framework.ddd.common.CommonHelper;
import com.huiju.framework.ddd.ime.annotation.ImeComponentAction;
import com.huiju.framework.ddd.ime.engine.ImeEngineComponentAction;
import com.huiju.framework.ddd.ime.engine.ImeEngineContext;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ImeComponentAction(component = WorkOrderComponent.class, desc = "工单排序", state = SortWorkOrderState.class
,prePlugin = SortWorkOrderCheckPreActionPlugin.class ,afterPlugin =SortWorkOrderCheckAfterActionPlugin.class ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class SortWorkOrderAction implements ImeEngineComponentAction<WorkOrderDTO, WorkOrderVO> {

    @Override
    public WorkOrderVO execute(WorkOrderDTO dto, ImeEngineContext<WorkOrderVO> context) throws Exception {
        System.out.println(">>>>调用工单排序动作点" + dto.getCode()+"----"+dto.getCode());
        return CommonHelper.copy(dto, WorkOrderVO.class);
    }
}

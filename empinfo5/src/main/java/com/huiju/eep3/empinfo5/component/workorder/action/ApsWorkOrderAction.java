package com.huiju.eep3.empinfo5.component.workorder.action;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.component.workorder.plugin.ApsWorkOrderCheckAfterActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.plugin.ApsWorkOrderCheckPreActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.state.ApsWorkOrderState;
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
@ImeComponentAction(component = WorkOrderComponent.class, desc = "工单排程动作点", state = ApsWorkOrderState.class
,prePlugin = ApsWorkOrderCheckPreActionPlugin.class ,afterPlugin =ApsWorkOrderCheckAfterActionPlugin.class ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class ApsWorkOrderAction implements ImeEngineComponentAction<WorkOrderDTO, WorkOrderVO> {

    @Override
    public WorkOrderVO execute(WorkOrderDTO dto, ImeEngineContext<WorkOrderVO> context) throws Exception {
        System.out.println(">>>>调用工单排程动作点" + dto.getCode()+"----"+dto.getCode());
        return CommonHelper.copy(dto, WorkOrderVO.class);
    }
}

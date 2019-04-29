package com.huiju.eep3.empinfo5.component.workorder.action;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.component.workorder.plugin.CreateWorkOrderCheckAfterActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.plugin.CreateWorkOrderCheckPreActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.state.CreateWorkOrderState;
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
@ImeComponentAction(component = WorkOrderComponent.class, desc = "创建工单", state = CreateWorkOrderState.class
,prePlugin = CreateWorkOrderCheckPreActionPlugin.class ,afterPlugin =CreateWorkOrderCheckAfterActionPlugin.class ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class CreateWorkOrderAction implements ImeEngineComponentAction<WorkOrderDTO, WorkOrderVO> {

    @Override
    public WorkOrderVO execute(WorkOrderDTO dto, ImeEngineContext<WorkOrderVO> context) throws Exception {
        System.out.println(">>>>调用创建工单动作点" + dto.getCode()+"----"+dto.getCode());
        return CommonHelper.copy(dto, WorkOrderVO.class);
    }
}

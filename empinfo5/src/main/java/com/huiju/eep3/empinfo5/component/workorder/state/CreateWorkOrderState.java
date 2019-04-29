package com.huiju.eep3.empinfo5.component.workorder.state;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.framework.ddd.ime.annotation.ImeComponentState;
import com.huiju.framework.ddd.ime.engine.impl.SimpleImeEngineComponentState;


@ImeComponentState(component = WorkOrderComponent.class, desc = "工单创建")
public class CreateWorkOrderState extends SimpleImeEngineComponentState {
    public CreateWorkOrderState() {
        super(1, "create-work-order");
    }
}

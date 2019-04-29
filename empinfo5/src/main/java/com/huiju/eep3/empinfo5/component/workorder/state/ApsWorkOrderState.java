package com.huiju.eep3.empinfo5.component.workorder.state;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.framework.ddd.ime.annotation.ImeComponentState;
import com.huiju.framework.ddd.ime.engine.impl.SimpleImeEngineComponentState;


@ImeComponentState(component = WorkOrderComponent.class, desc = "工单排程")
public class ApsWorkOrderState extends SimpleImeEngineComponentState {
    public ApsWorkOrderState() {
        super(3, "aps-work-order");
    }
}

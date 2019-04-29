package com.huiju.eep3.empinfo5.component.workorder;

import com.huiju.framework.ddd.ime.annotation.ImeComponent;
import com.huiju.framework.ddd.ime.engine.impl.SimpleImeEngineComponent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ImeComponent(desc = "workOrder")
public class WorkOrderComponent extends SimpleImeEngineComponent {
    public WorkOrderComponent(String id, String scene) {
        super(id, scene);
    }
}

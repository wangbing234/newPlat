package com.huiju.eep3.empinfo5.component.workorder.param;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.framework.ddd.ime.annotation.ImeComponentParam;
import com.huiju.framework.ddd.ime.engine.impl.SingleImeEngineComponentParam;


@ImeComponentParam(component = WorkOrderComponent.class, desc = "工单参数")
public class WorkOrderParam extends SingleImeEngineComponentParam {

    public WorkOrderParam() {
        this("WO001");
    }

    public WorkOrderParam(String value) {
        super("work-param", value);
    }
}

package com.huiju.eep3.empinfo5.component.workorder.after;

import com.huiju.eep3.empinfo5.component.workorder.action.ApsWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.action.CreateWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.action.SortWorkOrderAction;
import com.huiju.framework.ddd.ime.annotation.ImeComponentActionAfter;
import com.huiju.framework.ddd.ime.engine.ImeEngineComponent;
import com.huiju.framework.ddd.ime.engine.ImeEngineComponentActionAfter;
import com.huiju.framework.ddd.ime.engine.ImeEngineContext;


@ImeComponentActionAfter(actions = {CreateWorkOrderAction.class,SortWorkOrderAction.class,ApsWorkOrderAction.class}, desc = "发送工单信息")
public class SendWorkOrderActionAfter implements ImeEngineComponentActionAfter {
    @Override
    public void execute(ImeEngineComponent compInstane, ImeEngineContext<Object> context) throws Exception {
        System.out.println("发送工单信息"+context.getResult().toString());
    }
}

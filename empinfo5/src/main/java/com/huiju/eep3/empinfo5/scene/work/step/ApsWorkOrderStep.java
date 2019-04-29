package com.huiju.eep3.empinfo5.scene.work.step;

import com.huiju.eep3.empinfo5.component.workorder.action.ApsWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.component.workorder.plugin.ApsWorkOrderCheckAfterActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.plugin.ApsWorkOrderCheckPreActionPlugin;
import com.huiju.eep3.empinfo5.scene.work.WorkOrderScene;
import com.huiju.framework.ddd.ime.annotation.ImeScenePartAction;


@ImeScenePartAction(part = WorkOrderScene.class, action = ApsWorkOrderAction.class
        ,prePlugin =ApsWorkOrderCheckPreActionPlugin.class ,afterPlugin =ApsWorkOrderCheckAfterActionPlugin.class ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class ApsWorkOrderStep {

}

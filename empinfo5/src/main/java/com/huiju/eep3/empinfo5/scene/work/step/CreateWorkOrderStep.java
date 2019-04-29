package com.huiju.eep3.empinfo5.scene.work.step;

import com.huiju.eep3.empinfo5.component.workorder.action.CreateWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.component.workorder.plugin.CreateWorkOrderCheckAfterActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.plugin.CreateWorkOrderCheckPreActionPlugin;
import com.huiju.eep3.empinfo5.scene.work.WorkOrderScene;
import com.huiju.framework.ddd.ime.annotation.ImeScenePartAction;


@ImeScenePartAction(part = WorkOrderScene.class, action = CreateWorkOrderAction.class
        ,prePlugin =CreateWorkOrderCheckPreActionPlugin.class ,afterPlugin =CreateWorkOrderCheckAfterActionPlugin.class ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class CreateWorkOrderStep {

}

package com.huiju.eep3.empinfo5.scene.work.step;

import com.huiju.eep3.empinfo5.component.workorder.action.SortWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.component.workorder.plugin.SortWorkOrderCheckAfterActionPlugin;
import com.huiju.eep3.empinfo5.component.workorder.plugin.SortWorkOrderCheckPreActionPlugin;
import com.huiju.eep3.empinfo5.scene.work.WorkOrderScene;
import com.huiju.framework.ddd.ime.annotation.ImeScenePartAction;


@ImeScenePartAction(part = WorkOrderScene.class, action = SortWorkOrderAction.class
        ,prePlugin =SortWorkOrderCheckPreActionPlugin.class ,afterPlugin =SortWorkOrderCheckAfterActionPlugin.class ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class SortWorkOrderStep {

}

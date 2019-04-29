package com.huiju.eep3.empinfo5.scene.work;

import com.huiju.eep3.empinfo5.component.workorder.WorkOrderComponent;
import com.huiju.eep3.empinfo5.component.workorder.after.SendWorkOrderActionAfter;
import com.huiju.eep3.empinfo5.scene.work.step.ApsWorkOrderStep;
import com.huiju.eep3.empinfo5.scene.work.step.CreateWorkOrderStep;
import com.huiju.eep3.empinfo5.scene.work.step.SortWorkOrderStep;
import com.huiju.framework.ddd.ime.annotation.ImeScenePart;


@ImeScenePart(scene = SceneOne.class,
        component = WorkOrderComponent.class,
        actions = {
                CreateWorkOrderStep.class,
                SortWorkOrderStep.class,                
                ApsWorkOrderStep.class,
        },
        params = {
                "work-param€€WO002"}
        ,
        actionAfters = {SendWorkOrderActionAfter.class})
public class WorkOrderScene {
}

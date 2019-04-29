package com.huiju.eep3.empinfo5.component.workorder.plugin;

import com.huiju.eep3.empinfo5.component.workorder.action.SortWorkOrderAction;
import com.huiju.eep3.empinfo5.component.workorder.vo.WorkOrderVO;
import com.huiju.eep3.empinfo5.dto.WorkOrderDTO;
import com.huiju.framework.ddd.common.CommonHelper;
import com.huiju.framework.ddd.ime.annotation.ImeComponentActionPlugin;
import com.huiju.framework.ddd.ime.engine.ImeEngineComponentActionPlugin;
import com.huiju.framework.ddd.ime.engine.ImeEngineContext;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ImeComponentActionPlugin(action = SortWorkOrderAction.class, desc = "工单排序以后的检查", pluginType = ImeComponentActionPlugin.PluginType.AFTER)
public class SortWorkOrderCheckAfterActionPlugin implements ImeEngineComponentActionPlugin<WorkOrderDTO, WorkOrderVO> {
    @Override
    public WorkOrderVO execute(WorkOrderDTO dto, ImeEngineContext<WorkOrderVO> context) throws Exception {
        System.out.println(">>>>调用工单排序以后检查" );
        WorkOrderVO vo=context.getPreResult();
        if(null==vo){
            vo= CommonHelper.copy(dto,WorkOrderVO.class);
        }
        return vo;
    }
}

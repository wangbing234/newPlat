package com.huiju.eep3.empinfo5.command.workOrder;

import com.huiju.eep3.empinfo5.dto.WorkOrderDTO;
import com.huiju.framework.ddd.annotation.Cmd;
import lombok.Data;

@Data
@Cmd
public class AddWorkOrderCommand extends WorkOrderDTO {
    
    private String scene;
}
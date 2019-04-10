package com.huiju.eep3.empinfo5.command.workOrder;

import com.huiju.eep3.empinfo5.dto.WorkOrderDTO;
import com.huiju.framework.ddd.annotation.Cmd;
import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;

@Data
@Cmd
public class EditWorkOrderCommand extends WorkOrderDTO {

    @TargetAggregateIdentifier
    private String id;
}
package com.huiju.eep3.empinfo5.command.workOrder;

import com.huiju.eep3.empinfo5.dto.WorkOrder;
import com.huiju.framework.ddd.annotation.Cmd;
import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;

@Data
@Cmd
public class EditWorkOrderCommand extends WorkOrder {

    @TargetAggregateIdentifier
    private String id;
}
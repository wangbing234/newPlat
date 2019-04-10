package com.huiju.eep3.empinfo5.command.planOrder;

import com.huiju.eep3.empinfo5.dto.PlanOrderDTO;
import com.huiju.framework.ddd.annotation.Cmd;
import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;

@Data
@Cmd
public class PlanEditCommand extends PlanOrderDTO {

    @TargetAggregateIdentifier
    private String id;
}
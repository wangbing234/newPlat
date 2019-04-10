package com.huiju.eep3.empinfo5.command.planOrder;

import com.huiju.eep3.empinfo5.dto.PlanOrderDTO;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class PlanCreateCommand extends PlanOrderDTO {
}
package com.huiju.eep3.empinfo5.command.planOrder;

import com.huiju.framework.ddd.annotation.Cmd;
import lombok.Data;

import java.util.List;

@Data
@Cmd
public class PlanDispatchCommand {

    private List<String> ids;
}
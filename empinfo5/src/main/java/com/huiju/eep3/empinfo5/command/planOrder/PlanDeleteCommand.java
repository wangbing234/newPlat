package com.huiju.eep3.empinfo5.command.planOrder;

import java.util.*;
import java.math.*;

import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class PlanDeleteCommand {

    private List<String> ids;
}
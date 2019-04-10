package com.huiju.eep3.empinfo5.command.workOrder;

import com.huiju.framework.ddd.annotation.Cmd;
import lombok.Data;

import java.util.List;

@Data
@Cmd
public class FreezeCommand {
    private List<String> ids;
}
package com.huiju.eep3.empinfo5.command.workOrder;

import com.huiju.eep3.empinfo5.dto.BatchWorkOrderDTO;
import com.huiju.framework.ddd.annotation.Cmd;
import lombok.Data;

import java.util.List;

@Data
@Cmd
public class DoBatchCommand {
    private BatchWorkOrderDTO batchWorkOrderDTO;
}
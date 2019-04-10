package com.huiju.eep3.empinfo5.command.workOrder;

import com.huiju.framework.ddd.annotation.Cmd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Cmd
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderDispatchCommand implements Serializable {
    private String id;
}
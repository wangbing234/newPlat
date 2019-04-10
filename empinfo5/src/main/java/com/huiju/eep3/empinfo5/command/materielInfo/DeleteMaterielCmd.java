package com.huiju.eep3.empinfo5.command.materielInfo;

import com.huiju.framework.ddd.annotation.Cmd;
import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Cmd
@AllArgsConstructor
public class DeleteMaterielCmd {

    /**
     * ids数组
     */
    @TargetAggregateIdentifier
    private String id;
}
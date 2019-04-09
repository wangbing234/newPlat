package com.huiju.eep3.empinfo5.command.materielType;

import com.huiju.eep3.empinfo5.dto.MaterielTypeDTO;
import com.huiju.framework.ddd.annotation.Cmd;
import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;

@Data
@Cmd
public class EditTypeCommand extends MaterielTypeDTO {
//    @TargetAggregateIdentifier
    private String id;
}
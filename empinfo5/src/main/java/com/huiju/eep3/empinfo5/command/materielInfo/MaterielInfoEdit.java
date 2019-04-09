package com.huiju.eep3.empinfo5.command.materielInfo;

import java.util.*;
import java.math.*;

import com.huiju.eep3.empinfo5.dto.MaterielInfoDTO;
import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class MaterielInfoEdit  extends MaterielInfoDTO {
    /**
     * 物料编码
     */
    @TargetAggregateIdentifier
    private String id;
}
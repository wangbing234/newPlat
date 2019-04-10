package com.huiju.eep3.empinfo5.event.materielInfo;

import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeleteOneMaterielEvt implements Serializable {

    @TargetAggregateIdentifier
    private String id;
}
package com.huiju.eep3.empinfo5.event.materielInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseDeleteMaterielEvt implements Serializable {
    /**
     * 编码
     */
    private List<String> ids;
}
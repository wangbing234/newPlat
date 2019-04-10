package com.huiju.eep3.empinfo5.dto;

import lombok.Data;

@Data
public class MaterielTypeDTO {

    /**
     * code
     */
    private String id;
    /**
     * 父id
     */
    private String parentGid;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
}
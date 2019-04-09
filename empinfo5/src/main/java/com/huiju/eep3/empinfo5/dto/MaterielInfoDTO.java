package com.huiju.eep3.empinfo5.dto;

import lombok.Data;

import java.util.List;

@Data
public class MaterielInfoDTO {

    /**
     * 物料编码
     */
    private String code;
    /**
     * 物料名称
     */
    private String name;
    /**
     * 计量单位GID
     */
    private String bmMeasurementUnitGid;
    /**
     * 规格
     */
    private String spec;
    /**
     * 型号
     */
    private String model;
    /**
     * 默认仓库Gid
     */
    private String bmWarehouseGid;
    /**
     * 是否自制件
     */
    private Boolean homemadePiece;
    /**
     * 是否委外
     */
    private Boolean outsourcing;
    /**
     * 是否采购件
     */
    private Boolean purchaseParts;
    /**
     * 简称
     */
    private String abbreviation;

    /**
     * 简称
     */
    private List<String> ids;
}
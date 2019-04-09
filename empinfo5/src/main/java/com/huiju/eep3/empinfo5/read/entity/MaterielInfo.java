package com.huiju.eep3.empinfo5.read.entity;

import com.huiju.framework.ddd.repository.IdEntity;
import java.util.*;
import java.math.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.Entity;

@Data
@Slf4j
@Entity
public class MaterielInfo extends IdEntity {

	/**
	 * 主键
	 */
	private String gid;
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

}
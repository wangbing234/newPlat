package com.huiju.eep3.empinfo5.component.workorder.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class BmMaterielInfoVO implements Serializable {
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 物料类别GID
	 */
	private String materielTypeGid;
	/**
	 * 物料名称
	 */
	private String name;
	/**
	 * 物料编码
	 */
	private String code;


}
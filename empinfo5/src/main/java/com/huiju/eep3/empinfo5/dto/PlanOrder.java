package com.huiju.eep3.empinfo5.dto;

import java.util.Date;
import java.util.*;
import java.math.*;
import lombok.Data;

@Data
public class PlanOrder {

	/**
	 * code
	 */
	private String id;
	/**
	 * 产品
	 */
	private String bmProductAggGid;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 工作中心
	 */
	private String workCenterGid;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 计划数量
	 */
	private Integer planQty;
	/**
	 * 计划时间
	 */
	private Date planBeginTime;
}
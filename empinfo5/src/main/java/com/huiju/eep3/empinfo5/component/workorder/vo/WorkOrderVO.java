package com.huiju.eep3.empinfo5.component.workorder.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

@Data
@Slf4j
public class WorkOrderVO implements Serializable {
	/**
	 * 顺序
	 */
	private Long seq;
	/**
	 * 执行组织
	 */
	private String execOrg;
	/**
	 * 计划结束时间
	 */
	private Date planEndTime;
	/**
	 * 计划开始时间
	 */
	private Date planBeginTime;
	/**
	 * 数量
	 */
	private Integer qty;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 订单Gid
	 */
	private String planOrderGid;
	/**
	 * 物料Gid
	 */
	private String materielGid;
	/**
	 * 编码
	 */
	private String code;

}
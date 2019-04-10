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
public class WorkOrderEntity extends IdEntity {

    /**
     * 工单类别
     */
    private String orderType;
    /**
     * 生产工单来源类型
     */
    private String resourceOrderType;
    /**
     * 生产工单数量
     */
    public BigDecimal planQty;
    /**
     * 合格数量
     */
    private Integer qualifiedQty;
    /**
     * 不合格数量
     */
    private Integer unqualifiedQty;
    /**
     * 废品数量
     */
    private Integer wasteQty;
    /**
     * 批次号\轮次号
     */
    private String batchNumber;
    /**
     * 产品聚合Gid
     */
    private String bmProductAggGid;
    /**
     * 编码
     */
    private String code;

    /**
     * 计划开始时间
     */
    public java.util.Date planBeginTime;

    /**
     * 计划完成时间
     */
    public java.util.Date planEndTime;

    /**
     * 订单顺序号
     */
    public Integer seq;
}
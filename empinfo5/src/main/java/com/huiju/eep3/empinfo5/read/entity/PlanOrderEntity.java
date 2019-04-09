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
public class PlanOrderEntity extends IdEntity {
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
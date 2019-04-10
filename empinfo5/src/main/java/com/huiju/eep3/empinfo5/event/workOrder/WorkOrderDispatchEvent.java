package com.huiju.eep3.empinfo5.event.workOrder;

import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class WorkOrderDispatchEvent implements Serializable {

    PlanOrderEntity planOrderEntity;

}
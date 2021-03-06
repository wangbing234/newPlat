package com.huiju.eep3.empinfo5.event.workOrder;

import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class BatchAddWorkOrderEvent implements Serializable {

    private List<WorkOrderEntity> workOrderEntityList;
}
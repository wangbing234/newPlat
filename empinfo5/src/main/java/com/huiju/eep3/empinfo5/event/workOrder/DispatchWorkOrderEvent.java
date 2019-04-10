package com.huiju.eep3.empinfo5.event.workOrder;

import com.huiju.eep3.empinfo5.dto.WorkOrderDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class DispatchWorkOrderEvent  implements Serializable {

    private String id;
}
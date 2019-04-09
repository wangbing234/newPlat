package com.huiju.eep3.empinfo5.event.workOrder;

import com.huiju.eep3.empinfo5.dto.WorkOrder;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddWorkOrderEvent extends WorkOrder implements Serializable {
    /**
     * code
     */
    private String id;
}
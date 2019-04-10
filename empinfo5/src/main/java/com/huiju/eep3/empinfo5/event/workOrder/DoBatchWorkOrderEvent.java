package com.huiju.eep3.empinfo5.event.workOrder;

import com.huiju.eep3.empinfo5.dto.BatchWorkOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoBatchWorkOrderEvent implements Serializable {

    private BatchWorkOrderDTO batchWorkOrderDTO;
}
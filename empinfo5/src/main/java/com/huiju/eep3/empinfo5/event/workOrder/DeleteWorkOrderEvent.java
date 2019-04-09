package com.huiju.eep3.empinfo5.event.workOrder;

import java.io.Serializable;
import java.util.*;
import java.math.*;
import lombok.Data;

@Data
public class DeleteWorkOrderEvent implements Serializable {
    private List<String> ids;
}
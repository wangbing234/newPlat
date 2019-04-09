package com.huiju.eep3.empinfo5.event.planOrder;

import java.io.Serializable;
import java.util.*;
import java.math.*;
import lombok.Data;

@Data
public class PlanDeleteEvent implements Serializable {
    private List<String> ids;
}
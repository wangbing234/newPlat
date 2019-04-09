package com.huiju.eep3.empinfo5.event.planOrder;

import java.io.Serializable;
import java.util.*;
import java.math.*;

import com.huiju.eep3.empinfo5.dto.PlanOrder;
import lombok.Data;

@Data
public class PlanEditEvent  extends PlanOrder implements Serializable {

    /**
     * code
     */
    private String id;
}
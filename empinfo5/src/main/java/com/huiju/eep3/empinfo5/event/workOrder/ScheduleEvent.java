package com.huiju.eep3.empinfo5.event.workOrder;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ScheduleEvent implements Serializable {

    private List<String> ids;
}

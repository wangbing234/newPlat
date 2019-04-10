package com.huiju.eep3.empinfo5.event.planOrder;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChangeStatuisToDownEvent implements Serializable {
    private String id;
}
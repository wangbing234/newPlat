package com.huiju.eep3.empinfo5.event.employee;

import java.io.Serializable;
import java.util.*;
import java.math.*;
import lombok.Data;

@Data
public class CreateEvt implements Serializable {

	/**
	 * name
	 */
	private String name;
	/**
	 * instrest
	 */
	private String instrest;
	/**
	 * age
	 */
	private Integer age;
}
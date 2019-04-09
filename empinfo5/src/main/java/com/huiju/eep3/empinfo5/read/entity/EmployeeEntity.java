package com.huiju.eep3.empinfo5.read.entity;

import com.huiju.framework.ddd.repository.IdEntity;
import java.util.*;
import java.math.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.Entity;

@Data
@Slf4j
@Entity
public class EmployeeEntity extends IdEntity {

	/**
	 * age
	 */
	private Integer age;
	/**
	 * name
	 */
	private String name;
	/**
	 * instrest
	 */
	private String instrest;
}
package com.huiju.eep3.empinfo5.command.employee;

import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import java.util.*;
import java.math.*;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class CreateCommand {

	/**
	 * instrest
	 */
	private String instrest;
	/**
	 * name
	 */
	private String name;
	/**
	 * age
	 */
	private Integer age;
}
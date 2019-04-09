package com.huiju.eep3.empinfo5.command.materielType;

import java.util.*;
import java.math.*;

import com.huiju.framework.ddd.annotation.TargetAggregateIdentifier;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class DeleteTypeCommand {

	/**
	 * code
	 */
	private String id;
}
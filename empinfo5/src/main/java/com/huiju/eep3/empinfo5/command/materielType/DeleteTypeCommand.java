package com.huiju.eep3.empinfo5.command.materielType;

import java.util.*;
import java.math.*;
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
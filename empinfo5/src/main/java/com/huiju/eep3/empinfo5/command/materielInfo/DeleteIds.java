package com.huiju.eep3.empinfo5.command.materielInfo;

import java.util.List;
import java.util.*;
import java.math.*;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class DeleteIds {

	/**
	 * ids数组
	 */
	private List<String> ids;
}
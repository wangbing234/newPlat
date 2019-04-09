package com.huiju.eep3.empinfo5.command.materielType;

import java.util.*;
import java.math.*;

import com.huiju.eep3.empinfo5.dto.MaterielTypeDTO;
import lombok.Data;
import com.huiju.framework.ddd.annotation.Cmd;

@Data
@Cmd
public class EditTypeCommand extends MaterielTypeDTO {

	/**
	 * code
	 */
	private String id;
}
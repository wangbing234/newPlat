package com.huiju.eep3.empinfo5.event.materielType;

import java.io.Serializable;
import java.util.*;
import java.math.*;

import com.huiju.eep3.empinfo5.dto.MaterielTypeDTO;
import lombok.Data;

@Data
public class DeleteTypeEvt implements Serializable {

	/**
	 * code
	 */
	private String id;
}
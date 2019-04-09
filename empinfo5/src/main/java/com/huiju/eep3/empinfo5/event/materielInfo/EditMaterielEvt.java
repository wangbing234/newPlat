package com.huiju.eep3.empinfo5.event.materielInfo;

import java.io.Serializable;
import java.util.*;
import java.math.*;

import com.huiju.eep3.empinfo5.dto.MaterielInfoDTO;
import lombok.Data;

@Data
public class EditMaterielEvt extends MaterielInfoDTO implements Serializable {

	/**
	 * 编码
	 */
	private String id;
}
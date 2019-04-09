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
public class MaterielType extends IdEntity {

	/**
	 * 父id
	 */
	private String parentGid;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
}
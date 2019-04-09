package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.framework.core.repository.WiselyRepository;
import com.huiju.framework.ddd.annotation.QueryDefination;
import com.huiju.eep3.empinfo5.read.entity.MaterielType;
import java.util.*;
import java.math.*;

public interface MaterielTypeRepository extends WiselyRepository<MaterielType, String> {

	@Override
	List<MaterielType> findAll();
}
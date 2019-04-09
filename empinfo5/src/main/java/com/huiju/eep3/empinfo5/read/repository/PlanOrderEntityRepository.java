package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.framework.core.repository.WiselyRepository;
import com.huiju.framework.ddd.annotation.QueryDefination;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import java.util.*;
import java.math.*;

public interface PlanOrderEntityRepository
		extends
			WiselyRepository<PlanOrderEntity, String> {

	@Override
	List<PlanOrderEntity> findAll();

	void  deleteByGidIn(List<String> ids);
}
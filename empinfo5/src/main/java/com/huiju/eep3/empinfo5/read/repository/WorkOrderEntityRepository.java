package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.framework.core.repository.WiselyRepository;
import com.huiju.framework.ddd.annotation.QueryDefination;
import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import java.util.*;
import java.math.*;

public interface WorkOrderEntityRepository
		extends
			WiselyRepository<WorkOrderEntity, String> {

	@Override
	List<WorkOrderEntity> findAll();

	void  deleteByGidIn(List<String> ids);
}
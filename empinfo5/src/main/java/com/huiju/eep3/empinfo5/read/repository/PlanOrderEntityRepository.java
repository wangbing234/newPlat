package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.framework.core.repository.WiselyRepository;

import java.util.List;

public interface PlanOrderEntityRepository extends WiselyRepository<PlanOrderEntity, String> {

    @Override
    List<PlanOrderEntity> findAll();

    List<PlanOrderEntity> findByIdIn(List<String> ids);

    void deleteByIdIn(List<String> ids);

}
package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import com.huiju.framework.core.repository.WiselyRepository;

import java.util.List;

public interface WorkOrderEntityRepository
        extends
        WiselyRepository<WorkOrderEntity, String> {

    @Override
    List<WorkOrderEntity> findAll();

    void deleteByIdIn(List<String> ids);

    List<WorkOrderEntity> findByIdIn(List<String> ids);
}
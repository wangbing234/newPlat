package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.eep3.empinfo5.read.entity.MaterielInfo;
import com.huiju.framework.core.repository.WiselyRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MaterielInfoRepository extends WiselyRepository<MaterielInfo, String> {

    @Override
    List<MaterielInfo> findAll();

    List<MaterielInfo> findByMaterielTypeGid(String materielTypeGid);
}
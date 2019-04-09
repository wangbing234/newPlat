package com.huiju.eep3.empinfo5.read.repository;

import com.huiju.eep3.empinfo5.read.entity.MaterielInfo;
import com.huiju.framework.core.repository.WiselyRepository;
import com.huiju.framework.ddd.annotation.QueryDefination;
import com.huiju.eep3.empinfo5.read.entity.EmployeeEntity;
import java.util.*;
import java.math.*;

public interface EmployeeEntityRepository extends WiselyRepository<EmployeeEntity, String> {

    @Override
    List<EmployeeEntity> findAll();
}
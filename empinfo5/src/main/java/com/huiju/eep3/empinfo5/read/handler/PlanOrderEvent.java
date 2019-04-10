package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.eep3.empinfo5.enums.PlanOrderStatusEnums;
import com.huiju.eep3.empinfo5.event.planOrder.*;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.eep3.empinfo5.read.repository.PlanOrderEntityRepository;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class PlanOrderEvent {

    @Autowired
    private PlanOrderEntityRepository planOrderEntityRepository;

    /**
     * delete
     */
    @EventHandler
    @Transactional
    public void on(PlanDeleteEvent evt) {
        planOrderEntityRepository.deleteByIdIn(evt.getIds());
    }


    /**
     * add
     */
    @EventHandler
    public void on(ChangeStatuisToDownEvent evt) {
        Optional<PlanOrderEntity> planOrderEntityOptional =  planOrderEntityRepository.findById(evt.getId());
        planOrderEntityOptional.ifPresent(planOrderEntity->{
            planOrderEntity.setStatus(PlanOrderStatusEnums.DOWN.name());
            planOrderEntityRepository.save(planOrderEntity);
        });
    }

    /**
     * edit
     */
    @EventHandler
    public void on(PlanEditEvent evt) {
        PlanOrderEntity planOrderEntity = new PlanOrderEntity();
        BeanUtils.copyProperties(evt, planOrderEntity);
        planOrderEntityRepository.save(planOrderEntity);
    }



    /**
     * add
     */
    @EventHandler
    public void on(PlanAddEvent evt) {
        PlanOrderEntity planOrderEntity = new PlanOrderEntity();
        BeanUtils.copyProperties(evt, planOrderEntity);
        planOrderEntityRepository.save(planOrderEntity);
    }
}
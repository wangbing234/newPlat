package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.eep3.empinfo5.event.planOrder.PlanAddEvent;
import com.huiju.eep3.empinfo5.event.planOrder.PlanDeleteEvent;
import com.huiju.eep3.empinfo5.event.planOrder.PlanEditEvent;
import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.eep3.empinfo5.read.repository.PlanOrderEntityRepository;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
     * edit
     */
    @EventHandler
    public void on(PlanEditEvent evt) {
        PlanOrderEntity materielType = new PlanOrderEntity();
        BeanUtils.copyProperties(evt, materielType);
        planOrderEntityRepository.save(materielType);
    }

    /**
     * add
     */
    @EventHandler
    public void on(PlanAddEvent evt) {
        PlanOrderEntity materielType = new PlanOrderEntity();
        BeanUtils.copyProperties(evt, materielType, "id");
        planOrderEntityRepository.save(materielType);
    }
}
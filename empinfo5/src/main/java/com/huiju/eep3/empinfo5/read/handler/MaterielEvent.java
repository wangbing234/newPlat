package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.eep3.empinfo5.event.materielInfo.CreateMaterielEvt;
import com.huiju.eep3.empinfo5.event.materielInfo.BaseDeleteMaterielEvt;
import com.huiju.eep3.empinfo5.event.materielInfo.DeleteOneMaterielEvt;
import com.huiju.eep3.empinfo5.event.materielInfo.EditMaterielEvt;
import com.huiju.eep3.empinfo5.read.entity.MaterielInfo;
import com.huiju.eep3.empinfo5.read.repository.MaterielInfoRepository;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class MaterielEvent {

    @Autowired
    private MaterielInfoRepository materielInfoRepository;


    @EventHandler
    @Transactional
    public void on(DeleteOneMaterielEvt evt) {
        materielInfoRepository.deleteById(evt.getId());
    }




    /**
     * 编辑事件
     */
    @EventHandler
    public void on(EditMaterielEvt evt) {
        MaterielInfo materielInfo = new MaterielInfo();
        BeanUtils.copyProperties(evt, materielInfo);
        materielInfoRepository.save(materielInfo);
    }

    /**
     * 创建事件
     */
    @EventHandler
    public void on(CreateMaterielEvt evt) {
        MaterielInfo materielInfo = new MaterielInfo();
        BeanUtils.copyProperties(evt, materielInfo);
        materielInfoRepository.save(materielInfo);
    }
}
package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.eep3.empinfo5.read.entity.PlanOrderEntity;
import com.huiju.framework.ddd.annotation.EventHandler;
import com.huiju.eep3.empinfo5.event.workOrder.DeleteWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.EditWorkOrderEvent;
import com.huiju.eep3.empinfo5.event.workOrder.AddWorkOrderEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiju.eep3.empinfo5.read.repository.WorkOrderEntityRepository;
import com.huiju.eep3.empinfo5.read.entity.WorkOrderEntity;
import java.util.*;
import java.math.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class WorkOrderEvent {

	@Autowired
	private WorkOrderEntityRepository workOrderEntityRepository;

	/**
	 * delete
	 */
	@EventHandler
	@Transactional
	public void on(DeleteWorkOrderEvent evt) {
		workOrderEntityRepository.deleteByGidIn(evt.getIds());
	}

	/**
	 * edit
	 */
	@EventHandler
	public void on(EditWorkOrderEvent evt) {
		WorkOrderEntity materielType =new WorkOrderEntity();
		BeanUtils.copyProperties(evt,materielType);
		workOrderEntityRepository.save(materielType);
	}

	/**
	 * add
	 */
	@EventHandler
	public void on(AddWorkOrderEvent evt) {
		WorkOrderEntity materielType =new WorkOrderEntity();
		BeanUtils.copyProperties(evt,materielType,"id");
		workOrderEntityRepository.save(materielType);
	}
}
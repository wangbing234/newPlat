package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.framework.ddd.annotation.EventHandler;
import com.huiju.eep3.empinfo5.event.materielInfo.CreateMaterielEvt;
import com.huiju.eep3.empinfo5.event.employee.CreateEvt;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiju.eep3.empinfo5.read.repository.EmployeeEntityRepository;
import com.huiju.eep3.empinfo5.read.entity.EmployeeEntity;
import java.util.*;
import java.math.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeEvent {

	@Autowired
	private EmployeeEntityRepository employeeEntity;

	/**
	 * 创建物料
	 */
	@EventHandler
	public void on(CreateMaterielEvt evt) {
	}

	/**
	 * 创建成功事件
	 */
	@EventHandler
	public void on(CreateEvt evt) {
	}
}
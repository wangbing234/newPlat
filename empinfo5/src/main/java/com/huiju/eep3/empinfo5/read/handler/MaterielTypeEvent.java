package com.huiju.eep3.empinfo5.read.handler;

import com.huiju.framework.ddd.annotation.EventHandler;
import com.huiju.eep3.empinfo5.event.materielType.DeleteTypeEvt;
import com.huiju.eep3.empinfo5.event.materielType.EditTypeEvt;
import com.huiju.eep3.empinfo5.event.materielType.AddTypeEvt;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiju.eep3.empinfo5.read.repository.MaterielTypeRepository;
import com.huiju.eep3.empinfo5.read.entity.MaterielType;
import java.util.*;
import java.math.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MaterielTypeEvent {

	@Autowired
	private MaterielTypeRepository materielTypeRepository;

	/**
	 * delete
	 */
	@EventHandler
	public void on(DeleteTypeEvt evt) {
	}

	/**
	 * edit
	 */
	@EventHandler
	public void on(EditTypeEvt evt) {
	}

	/**
	 * add
	 */
	@EventHandler
	public void on(AddTypeEvt evt) {
	}
}
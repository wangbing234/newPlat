package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.materielType.AddTypeCommand;
import com.huiju.eep3.empinfo5.command.materielType.DeleteTypeCommand;
import com.huiju.eep3.empinfo5.command.materielType.EditTypeCommand;
import com.huiju.eep3.empinfo5.event.materielType.AddTypeEvt;
import com.huiju.eep3.empinfo5.event.materielType.DeleteTypeEvt;
import com.huiju.eep3.empinfo5.event.materielType.EditTypeEvt;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MaterielType extends SimpleAggregate {

    /**
     * code
     */
    private String code;

    /**
     * 增加分类
     */
    @CommandHandler
    public void handler(AddTypeCommand cmd) {
    }

    /**
     * 修改分类
     */
    @CommandHandler
    public void handler(EditTypeCommand cmd) {
    }

    /**
     * 删除分类
     */
    @CommandHandler
    public void handler(DeleteTypeCommand cmd) {
    }

    /**
     * AddTypeEvt事件处理
     */
    @EventHandler
    public void on(AddTypeEvt evt) {
    }

    /**
     * EditTypeEvt事件处理
     */
    @EventHandler
    public void on(EditTypeEvt evt) {
    }

    /**
     * DeleteTypeEvt事件处理
     */
    @EventHandler
    public void on(DeleteTypeEvt evt) {
    }
}
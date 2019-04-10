package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.materielType.AddTypeCommand;
import com.huiju.eep3.empinfo5.command.materielType.DeleteTypeCommand;
import com.huiju.eep3.empinfo5.command.materielType.EditTypeCommand;
import com.huiju.eep3.empinfo5.event.materielType.AddTypeEvt;
import com.huiju.eep3.empinfo5.event.materielType.DeleteTypeEvt;
import com.huiju.eep3.empinfo5.event.materielType.EditTypeEvt;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

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
        AddTypeEvt addTypeEvt = new AddTypeEvt();
        BeanUtils.copyProperties(cmd, addTypeEvt);
        addTypeEvt.setId(getAggregateId());
        AggregateLifecycle.apply(addTypeEvt);
    }

    /**
     * 修改分类
     */
    @CommandHandler
    public void handler(EditTypeCommand cmd) {
        EditTypeEvt addTypeEvt = new EditTypeEvt();
        BeanUtils.copyProperties(cmd, addTypeEvt);
        AggregateLifecycle.apply(addTypeEvt);
    }

    /**
     * 删除分类
     */
    @CommandHandler
    public void handler(DeleteTypeCommand cmd) {
        DeleteTypeEvt deleteMaterielEvt = new DeleteTypeEvt();
        deleteMaterielEvt.setId(cmd.getId());
        AggregateLifecycle.apply(deleteMaterielEvt);
    }

    /**
     * AddTypeEvt事件处理
     */
    @EventHandler
    public void on(AddTypeEvt evt) {
        BeanUtils.copyProperties(evt, this);
    }

    /**
     * EditTypeEvt事件处理
     */
    @EventHandler
    public void on(EditTypeEvt evt) {
        BeanUtils.copyProperties(evt, this);
    }

    /**
     * DeleteTypeEvt事件处理
     */
    @EventHandler
    public void on(DeleteTypeEvt evt) {
        AggregateLifecycle.destory();
    }
}
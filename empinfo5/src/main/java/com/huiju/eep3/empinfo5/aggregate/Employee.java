package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.employee.CreateCommand;
import com.huiju.eep3.empinfo5.command.employee.QueryCommand;
import com.huiju.eep3.empinfo5.event.employee.CreateEvt;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Employee extends SimpleAggregate {

    public Employee() {
        super();
    }

    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 兴趣
     */
    private String instrest;

    /**
     * 查询
     */
    @CommandHandler
    public void handler(QueryCommand cmd) {
    }

    /**
     * 创建
     */
    @CommandHandler
    public void handler(CreateCommand cmd) {
        CreateEvt createEvt = new CreateEvt();
        createEvt.setAge(cmd.getAge());
        createEvt.setInstrest(cmd.getInstrest());
        createEvt.setName(cmd.getName());
        AggregateLifecycle.apply(createEvt);
    }

    /**
     * CreateEvt事件处理
     */
    @EventHandler
    public void on(CreateEvt evt) {
        this.name = evt.getName();
        this.age = evt.getAge();
        this.instrest = evt.getInstrest();
    }
}
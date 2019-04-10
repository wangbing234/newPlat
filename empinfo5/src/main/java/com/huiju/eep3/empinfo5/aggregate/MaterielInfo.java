package com.huiju.eep3.empinfo5.aggregate;

import com.huiju.eep3.empinfo5.command.materielInfo.DeleteIds;
import com.huiju.eep3.empinfo5.command.materielInfo.MaterielInfoADD;
import com.huiju.eep3.empinfo5.command.materielInfo.MaterielInfoEdit;
import com.huiju.eep3.empinfo5.event.materielInfo.CreateMaterielEvt;
import com.huiju.eep3.empinfo5.event.materielInfo.DeleteMaterielEvt;
import com.huiju.eep3.empinfo5.event.materielInfo.EditMaterielEvt;
import com.huiju.framework.ddd.aggregate.AggregateLifecycle;
import com.huiju.framework.ddd.aggregate.SimpleAggregate;
import com.huiju.framework.ddd.annotation.CommandHandler;
import com.huiju.framework.ddd.annotation.EventHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Data
@Slf4j
public class MaterielInfo extends SimpleAggregate {

    /**
     * 物料编码
     */
    private String code;
    /**
     * 物料名称
     */
    private String name;
    /**
     * 计量单位GID
     */
    private String bmMeasurementUnitGid;
    /**
     * 规格
     */
    private String spec;
    /**
     * 型号
     */
    private String model;
    /**
     * 默认仓库Gid
     */
    private String bmWarehouseGid;
    /**
     * 是否自制件
     */
    private Boolean homemadePiece;
    /**
     * 是否委外
     */
    private Boolean outsourcing;
    /**
     * 是否采购件
     */
    private Boolean purchaseParts;

    /**
     * 物料分类
     */
    private String   materielTypeGid;

    /**
     * 简称
     */
    private String abbreviation;



    /**
     * 删除物料
     */
    @CommandHandler
    public void handler(DeleteIds cmd) {
        DeleteMaterielEvt deleteMaterielEvt = new DeleteMaterielEvt();
        deleteMaterielEvt.setIds(cmd.getIds());
        AggregateLifecycle.apply(deleteMaterielEvt);
    }

    /**
     * 修改物料
     */
    @CommandHandler
    public void handler(MaterielInfoEdit cmd) {
        EditMaterielEvt materielInfoEdit = new EditMaterielEvt();
        BeanUtils.copyProperties(cmd,materielInfoEdit);
        AggregateLifecycle.apply(materielInfoEdit);
    }

    /**
     * 增加物料
     */
    @CommandHandler
    public void handler(MaterielInfoADD cmd) {
        CreateMaterielEvt materielInfoEdit = new CreateMaterielEvt();
        BeanUtils.copyProperties(cmd,materielInfoEdit);
        materielInfoEdit.setId(getAggregateId());
        AggregateLifecycle.apply(materielInfoEdit);
    }

    /**
     * CreateMaterielEvt事件处理
     */
    @EventHandler
    public void on(CreateMaterielEvt evt) {
        BeanUtils.copyProperties(evt,this);
    }

    /**
     * EditMaterielEvt事件处理
     */
    @EventHandler
    public void on(EditMaterielEvt evt) {
        BeanUtils.copyProperties(evt,this);
    }



}
package com.huiju.eep3.empinfo5.saga;

import com.huiju.eep3.empinfo5.command.materielInfo.DeleteMaterielCmd;
import com.huiju.eep3.empinfo5.event.materielInfo.BaseDeleteMaterielEvt;
import com.huiju.framework.ddd.saga.annotation.SagaEventHandler;
import com.huiju.framework.ddd.saga.annotation.Sagas;
import com.huiju.framework.ddd.saga.annotation.StartSaga;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AccountCreatedEvt Saga
 *
 * @author wangkai
 * @since 2018/11/16.
 */
@Slf4j
@Sagas
public class DeleteMaterielInfoSaga {


    @StartSaga
    @SagaEventHandler
    public List<DeleteMaterielCmd> on(BaseDeleteMaterielEvt evt) {
        return evt.getIds().stream().map(id -> new DeleteMaterielCmd(id)).collect(Collectors.toList());
    }


}

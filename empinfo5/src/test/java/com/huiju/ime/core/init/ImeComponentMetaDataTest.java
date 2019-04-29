package com.huiju.ime.core.init;

import static com.huiju.framework.ddd.common.CommonHelper.toJson;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.huiju.eep3.empinfo5.scene.work.SceneOne;
import com.huiju.framework.ddd.configuration.EnableDdd;
import com.huiju.framework.ddd.helper.CollectionHelper;
import com.huiju.framework.ddd.ime.configuration.EnableImeEngine;
import com.huiju.framework.ddd.ime.metadata.ImeMetaDataManager;
import com.huiju.framework.ddd.ime.metadata.bean.ImeComponentBean;
import com.huiju.framework.ddd.ime.metadata.bean.ImeSceneBean;
import com.huiju.framework.ddd.ime.metadata.entity.ImeComponentEntity;
import com.huiju.framework.ddd.ime.metadata.helper.ImeSceneMetaDataHelper;
import com.huiju.framework.ddd.ime.metadata.repository.ImeComponentRepository;
import com.huiju.framework.ddd.ime.scene.SceneBeanInMemory;
import com.huiju.framework.ddd.ime.scene.SceneManager;
import com.huiju.framework.ddd.ime.scene.ScenePartBean;

/**
 * Ime Component metaData Test
 *
 * @author wangkai
 * @since 2019/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImeComponentMetaDataTest.class)
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class})
@EnableDdd
@EnableImeEngine
public class ImeComponentMetaDataTest {
    @Autowired
    private ImeMetaDataManager metaDataManager;

    /**
     * 搜集组件相关元数据，并保存入库
     */
    @Test
    public void initComponent() {
        List<ImeComponentBean> comps = metaDataManager.getComponents();
        System.out.println(toJson(comps));
        for (ImeComponentBean comp : comps) {
            String id = metaDataManager.save(comp);
            Assert.assertNotNull(id);
        }
    }

    @Autowired
    private ImeComponentRepository componentRepository;

    @Test
    public void loadFromDb() {
        List<ImeComponentEntity> beans = componentRepository.findAll();
        Assert.assertTrue(CollectionHelper.notEmpty(beans));
        beans.stream().forEach(bean -> {
            ImeComponentBean comp = JSONObject.parseObject(bean.getData(), ImeComponentBean.class);
            System.out.println("================================");
            System.out.println(comp.getDesc());
            System.out.println("actionAfters:" + comp.getActionAfters().size());
            System.out.println("actions:" + comp.getActions().size());
            System.out.println("states:" + comp.getStates().size());
            System.out.println("params:" + comp.getParams().size());
        });
    }

    @Autowired
    private ImeSceneMetaDataHelper imeSceneMetaDataHelper;

    /**
     * 搜集场景相关元数据并保存入库
     */
    @Test
    public void initScene() {
        
        ImeSceneBean sceneBean1 = imeSceneMetaDataHelper.build(SceneOne.class);
        sceneBean1.setId("scene01");
        metaDataManager.save(sceneBean1);
        
       

    }

    @Autowired
    private SceneManager sceneManager;

    @Test
    public void loadSceneFromDb() {
        List<ImeSceneBean> sceneBeans = metaDataManager.findAllScene();
        Assert.assertTrue(CollectionHelper.notEmpty(sceneBeans));
        for (ImeSceneBean imeSceneBean : sceneBeans) {
//            System.out.println("================");
//            System.out.println(imeSceneBean.getDesc());
//            System.out.println("id:" + imeSceneBean.getId());
//            System.out.println("preinstalled:" + imeSceneBean.isPreinstalled());
//            System.out.println("parts:" + imeSceneBean.getParts().size());
            SceneBeanInMemory sceneBeanInMemory = sceneManager.getScene(imeSceneBean.getId());
            System.out.println("场景的运行时信息：");
            System.out.println("名称：" + sceneBeanInMemory.getDesc());
            System.out.println("参数：" + sceneBeanInMemory.getParams().size());
            sceneBeanInMemory.getParams().entrySet().stream().forEach(entry -> {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            });
            System.out.println("部件数：" + sceneBeanInMemory.getParts().size());
            sceneBeanInMemory.getParts().entrySet().stream().forEach(entry -> {
                ScenePartBean partBean = entry.getValue();
                System.out.println("-------------------------");
                System.out.println("部件:" + partBean.getDesc());
                System.out.println("部件关联Class:" + entry.getKey());
                System.out.println("部件actions:" + partBean.getActions().size());
                System.out.println("部件states:" + partBean.getStates().size());
                System.out.println("部件actionAfters:" + partBean.getActionAfterTypes().size());
            });
        }

    }
}


package com.huiju.eep3.empinfo5.read.repository.impl;

import com.huiju.eep3.empinfo5.TreeBuilderUtil;
import com.huiju.eep3.empinfo5.TreeNodeDTO;
import com.huiju.eep3.empinfo5.read.entity.MaterielType;
import com.huiju.eep3.empinfo5.read.repository.MaterielTypeRepository;
import com.huiju.framework.ddd.annotation.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AppService
public class MaterielTypeRepositoryService {

    @Autowired
    MaterielTypeRepository materielTypeRepository;

    public List<TreeNodeDTO> findAll(){
        List<TreeNodeDTO> trees = new ArrayList<TreeNodeDTO>();
        List<MaterielType> bmMaterielTypeList = materielTypeRepository.findAll();
        if(CollectionUtils.isEmpty(bmMaterielTypeList)) {
            return Collections.EMPTY_LIST;
        } else {
            TreeNodeDTO root = new TreeNodeDTO();
            root.setId("0");
            root.setCode("root");
            root.setText("物料分类");
            trees.add(root);
            for (MaterielType materiel : bmMaterielTypeList) {
                if (materiel != null) {
                    TreeNodeDTO treeDto = new TreeNodeDTO();
                    treeDto.setId(StringUtils.isEmpty(materiel.getId()) ? null : materiel.getId());
                    treeDto.setCode(StringUtils.isEmpty(materiel.getCode()) ? null : materiel.getCode());
                    treeDto.setText(StringUtils.isEmpty(materiel.getName()) ? null : materiel.getName());
                    treeDto.setPid(StringUtils.isEmpty(materiel.getParentGid()) ? "0" : materiel.getParentGid());
                    trees.add(treeDto);
                }
            }
            TreeBuilderUtil treeBuilder = new TreeBuilderUtil(trees);
            List<TreeNodeDTO> nodeDto = treeBuilder.buildListTree();
            return nodeDto;
        }
    }
}

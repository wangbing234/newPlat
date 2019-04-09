//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.huiju.eep3.empinfo5;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class TreeBuilderUtil {
    List<TreeNodeDTO> TreeNodeDTOs = new ArrayList();
    private String type;

    public TreeBuilderUtil(List<TreeNodeDTO> TreeNodeDTOs) {
        this.TreeNodeDTOs = TreeNodeDTOs;
    }

    public TreeBuilderUtil(List<TreeNodeDTO> TreeNodeDTOs, String type) {
        this.type = type;
        this.TreeNodeDTOs = TreeNodeDTOs;
    }

    public String buildJSONTree() {
        List<TreeNodeDTO> nodeTree = this.buildTree();
        return JSON.toJSONString(nodeTree);
    }

    public List<TreeNodeDTO> buildListTree() {
        List<TreeNodeDTO> nodeTree = this.buildTree();
        return nodeTree;
    }

    public List<TreeNodeDTO> buildTree() {
        List<TreeNodeDTO> treeTreeNodeDTOs = new ArrayList();
        List<TreeNodeDTO> rootTreeNodeDTOs = this.getRootTreeNodeDTOs();
        Iterator var3 = rootTreeNodeDTOs.iterator();

        while(var3.hasNext()) {
            TreeNodeDTO rootTreeDTO = (TreeNodeDTO)var3.next();
            this.buildChildTreeNodeDTOs(rootTreeDTO);
            treeTreeNodeDTOs.add(rootTreeDTO);
        }

        return treeTreeNodeDTOs;
    }

    public void buildChildTreeNodeDTOs(TreeNodeDTO TreeDTO) {
        List<TreeNodeDTO> children = this.getChildTreeNodeDTOs(TreeDTO);
        if (!children.isEmpty()) {
            Iterator var3 = children.iterator();

            while(var3.hasNext()) {
                TreeNodeDTO child = (TreeNodeDTO)var3.next();
                this.buildChildTreeNodeDTOs(child);
            }

            if ("children".equals(this.type)) {
                TreeDTO.setChildren(children);
            } else {
                TreeDTO.setChilds(children);
            }
        }

    }

    public List<TreeNodeDTO> getChildTreeNodeDTOs(TreeNodeDTO pTreeDTO) {
        List<TreeNodeDTO> childTreeNodeDTOs = new ArrayList();
        Iterator var3 = this.TreeNodeDTOs.iterator();

        while(var3.hasNext()) {
            TreeNodeDTO n = (TreeNodeDTO)var3.next();
            if (pTreeDTO.getId().equals(n.getPid())) {
                childTreeNodeDTOs.add(n);
            }
        }

        return childTreeNodeDTOs;
    }

    public boolean rootTreeDTO(TreeNodeDTO TreeDTO) {
        boolean isRootTreeDTO = true;
        if (StringUtils.isNotBlank(TreeDTO.getPid())) {
            Iterator var3 = this.TreeNodeDTOs.iterator();

            while(var3.hasNext()) {
                TreeNodeDTO n = (TreeNodeDTO)var3.next();
                if (TreeDTO.getPid().equals(n.getId())) {
                    isRootTreeDTO = false;
                    break;
                }
            }
        }

        return isRootTreeDTO;
    }

    public List<TreeNodeDTO> getRootTreeNodeDTOs() {
        List<TreeNodeDTO> rootTreeNodeDTOs = new ArrayList();
        Iterator var2 = this.TreeNodeDTOs.iterator();

        while(var2.hasNext()) {
            TreeNodeDTO n = (TreeNodeDTO)var2.next();
            if (this.rootTreeDTO(n)) {
                rootTreeNodeDTOs.add(n);
            }
        }

        return rootTreeNodeDTOs;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.huiju.eep3.empinfo5.utils;

import java.io.Serializable;
import java.util.List;

public class TreeNodeDTO implements Serializable {
    private static final long serialVersionUID = 4214344288219280437L;
    private String id;
    private String pid;
    private String code;
    private String name;
    private String parentCode;
    private String parentName;
    private String text;
    private String objId;
    private String methodName;
    private String url;
    private String icon;
    private String menuLevel;
    private boolean disabled;
    private boolean active;
    private boolean virtual;
    private String applicationInstanceId;
    private String smBusiGroupGid;
    private String smBusiUnitGid;
    private List<? extends TreeNodeDTO> childs;
    private List<? extends TreeNodeDTO> children;

    public TreeNodeDTO() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getObjId() {
        return this.objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<? extends TreeNodeDTO> getChilds() {
        return this.childs;
    }

    public void setChilds(List<? extends TreeNodeDTO> childs) {
        this.childs = childs;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isVirtual() {
        return this.virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public String getApplicationInstanceId() {
        return this.applicationInstanceId;
    }

    public void setApplicationInstanceId(String applicationInstanceId) {
        this.applicationInstanceId = applicationInstanceId;
    }

    public List<? extends TreeNodeDTO> getChildren() {
        return this.children;
    }

    public void setChildren(List<? extends TreeNodeDTO> children) {
        this.children = children;
    }

    public String getSmBusiGroupGid() {
        return this.smBusiGroupGid;
    }

    public void setSmBusiGroupGid(String smBusiGroupGid) {
        this.smBusiGroupGid = smBusiGroupGid;
    }

    public String getSmBusiUnitGid() {
        return this.smBusiUnitGid;
    }

    public void setSmBusiUnitGid(String smBusiUnitGid) {
        this.smBusiUnitGid = smBusiUnitGid;
    }

    public String getMenuLevel() {
        return this.menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }
}

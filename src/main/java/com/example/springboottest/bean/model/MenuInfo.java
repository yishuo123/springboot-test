package com.example.springboottest.bean.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 权限信息类
 */
public class MenuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;            //菜单ID

    private String menuName;    //菜单名称

    private String menuIcon;    //菜单图标

    private String url;            //请求路径

    private int level;            //菜单等级 1：父级菜单； 2：二级菜单

    private String parentId;    //一级菜单ID

    private String parentName;   //一次菜单名称

    private int status;            //状态

    private int displayOrder;    //显示顺序

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuIconStr() {
        if (StringUtils.isNotBlank(this.menuIcon)) {
            return "<i class=\"menu-icon fa " + this.menuIcon + "\"></i>";
        }
        return "";
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", url='" + url + '\'' +
                ", level=" + level +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", status=" + status +
                ", displayOrder=" + displayOrder +
                ", remark='" + remark + '\'' +
                '}';
    }
}

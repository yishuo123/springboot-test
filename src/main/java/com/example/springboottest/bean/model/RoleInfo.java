package com.example.springboottest.bean.model;

import java.io.Serializable;

/**
 * 角色信息
 *
 * @author lizy
 * 2016年11月28日
 */
public class RoleInfo implements Serializable {

    public static final int ROLECODE_1 = 1;        //角色编码	1：超级管理员
    public static final int ROLECODE_2 = 2;        //角色编码	2：管理员

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;            //角色id

    private String roleName;    //角色名称

    private Integer roleCode;        //角色编码

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleCode=" + roleCode +
                '}';
    }
}

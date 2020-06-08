package com.example.springboottest.bean.model;

import java.io.Serializable;

/**
 * 角色权限中间表
 * @author lizy
 * 2016年12月10日
 */
public class RoleMenuInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long roleId;
	
	private Long menuId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "RoleMenuInfo{" +
				"id='" + id + '\'' +
				", roleId='" + roleId + '\'' +
				", menuId='" + menuId + '\'' +
				'}';
	}
}

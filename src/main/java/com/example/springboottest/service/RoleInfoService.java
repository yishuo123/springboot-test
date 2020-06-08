package com.example.springboottest.service;


import com.example.springboottest.bean.model.RoleInfo;

import java.util.List;

/**
 * 角色信息Service 层接口
 * @author lizy
 * 2016年11月28日
 */
public interface RoleInfoService {

	/**
	 * 获取所有角色信息
	 * @param roleName		当前登录用户的角色
	 * @return
	 * @throws Exception
	 */
	List<RoleInfo> getRoleInfo(String roleName)throws Exception;

	/**
	 * 添加角色信息
	 * @param roleInfo
	 * @throws Exception
	 */
	void add(RoleInfo roleInfo) throws Exception;

	/**
	 * 修改角色信息
	 * @param roleInfo
	 * @throws Exception
	 */
	void update(RoleInfo roleInfo) throws Exception;

	/**
	 * 根据ID批量删除角色信息
	 * @param ids
	 * @throws Exception
	 */
	void del(Long[] ids)throws Exception;

	/**
	 * 验证用户名是否存在
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	RoleInfo existroleName(String roleName) throws Exception;
}

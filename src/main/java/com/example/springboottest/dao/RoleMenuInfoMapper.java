package com.example.springboottest.dao;

import com.example.springboottest.bean.model.RoleMenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限中间表Mapper
 * @author lizy
 * 2016年12月10日
 */
@Mapper
public interface RoleMenuInfoMapper {

	/**
	 * 根据角色ID和菜单ID查询中间表
	 * @param roleId	角色ID
	 * @param menuId	菜单ID
	 * @return
	 * @throws Exception
	 */
	int findRoleMenuInfoByRoleIdAndMenuId(@Param("roleId") Long roleId, @Param("menuId") Long menuId)throws Exception;
	
	/**
	 * 根据角色ID删除上次绑定的权限信息
	 * @param roleId
	 * @throws Exception
	 */
	void delRoleMenuByRoleId(@Param("roleId") Long roleId)throws Exception;
	
	/**
	 * 为角色添加权限
	 * @throws Exception
	 */
	void addRoleMenu(RoleMenuInfo roleMenuInfo)throws Exception;
	
	/**
	 * 根据角色ID查询相应的权限
	 * @param roleId	角色ID
	 * @return
	 * @throws Exception
	 */
	List<RoleMenuInfo> findRoleMenuInfoByRoleId(@Param("roleId") Long roleId)throws Exception;
	
}

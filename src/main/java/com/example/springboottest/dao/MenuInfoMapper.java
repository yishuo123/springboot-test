package com.example.springboottest.dao;

import com.example.springboottest.bean.model.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 菜单权限信息Mapper
 * @author lizy
 * 2016年11月28日
 */
@Mapper
public interface MenuInfoMapper {

	/**
	 * 根据ID查询菜单信息
	 * @param id	id
	 * @return
	 */
	MenuInfo findMenuInfoById(@Param("id") Long id);
	
	/**
	 * 根据条件获取全部菜单权限
	 * @return
	 */
	List<MenuInfo> findMenuInfoByParams(Map<String, Object> params)throws Exception;
	/**
	 * 根据条件获取子菜单信息
	 * @return
	 */
	List<MenuInfo> findMenuInfoSon(Long pid)throws Exception;
	
	/**
	 * 获取所有父级节点的菜单
	 * @return		返回父级节点
	 * @throws Exception
	 */
	List<MenuInfo> findMenuInfoParent()throws Exception;
	
	/**
	 * 添加菜单信息
	 * @param menuInfo	菜单信息
	 * @throws Exception
	 */
	void add(MenuInfo menuInfo)throws Exception;
	
	/**
	 * 修改菜单信息
	 * @param menuInfo 菜单信息
	 * @throws Exception
	 */
	void update(MenuInfo menuInfo)throws Exception;
	
	/**
	 * 批量删除菜单信息
	 * @param ids  菜单信息ID
	 * @throws Exception
	 */
	void del(String[] ids)throws Exception;
	
	/**
	 * 根据父级节点ID查询子菜单
	 * @param parentId	父级节点ID
	 * @return
	 * @throws Exception
	 */
	int findMenuInfoByParentId(@Param("parentId") Long parentId)throws Exception;
	
	/**
	 * 根据角色ID关联查询菜单信息
	 * @param roleId	角色ID
	 * @return
	 * @throws Exception
	 */
	List<MenuInfo> findMenuInfoByRoleId(@Param("roleId") Long roleId)throws Exception;
}

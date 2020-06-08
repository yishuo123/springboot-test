package com.example.springboottest.dao;

import com.example.springboottest.bean.model.RoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色信息Mapper
 * @author lizy
 * 2016年11月28日
 */
@Mapper
public interface RoleInfoMapper {

	/**
	 * 获取全部角色信息
	 * @return
	 */
	List<RoleInfo> getRoleInfo(@Param("roleName") String roleName)throws Exception;

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
	 * 效验用户是否已经存在
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	RoleInfo existroleName(String roleName) throws Exception;
}

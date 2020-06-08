package com.example.springboottest.service.impl;

import com.example.springboottest.bean.model.RoleInfo;
import com.example.springboottest.dao.RoleInfoMapper;
import com.example.springboottest.service.RoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息Service 层接口实现类
 * @author lizy
 * 2016年11月28日
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	@Resource
	protected RoleInfoMapper roleInfoMapper;
	
	/**
	 *  获取所有角色信息
	 */
	@Override
	public List<RoleInfo> getRoleInfo(String roleName) throws Exception {
		
		return roleInfoMapper.getRoleInfo(roleName);
		
	}

	/**
	 * 添加角色信息
	 * @param roleInfo
	 * @throws Exception
	 */
	@Override
	public void add(RoleInfo roleInfo) throws Exception {
		roleInfoMapper.add(roleInfo);
	}

	/**
	 * 修改角色信息
	 * @param roleInfo
	 * @throws Exception
	 */
	@Override
	public void update(RoleInfo roleInfo) throws Exception {
		roleInfoMapper.update(roleInfo);
	}

	/**
	 * 根据ID批量删除角色信息
	 * @param ids
	 * @throws Exception
	 */
	@Override
	public void del(Long[] ids) throws Exception {
		roleInfoMapper.del(ids);
	}


	/**
	 * 效验用户是否已经存在
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	@Override
	public RoleInfo existroleName(String roleName) throws Exception {
		return roleInfoMapper.existroleName(roleName);
	}



}

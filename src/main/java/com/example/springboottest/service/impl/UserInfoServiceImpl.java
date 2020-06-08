package com.example.springboottest.service.impl;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.dao.UserInfoMapper;
import com.example.springboottest.service.UserInfoService;
import com.example.springboottest.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 会员信息Service层接口实现类
 * @author lizy
 * 2016年11月27日
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	protected UserInfoMapper userInfoMapper;
	
	/**
	 * 用户登录
	 */
	@Override
	public UserInfo findUserInfoByUserNameAndPwd(String userName, String pwd) throws Exception {
		List<UserInfo> userInfo = userInfoMapper.findUserInfoByUserNameAndPwd(userName, pwd);
		
		if(userInfo!=null && userInfo.size() >0 ){
			return userInfo.get(0);
		}
		return null;
	}

	/**
	 * 根据条件分页查询会员信息
	 */
	@Override
	public Page<UserInfo> findUserInfoPages(Map<String, Object> params) throws Exception {
		

		List<UserInfo> list = userInfoMapper.selectUserInfoByParams(params);
		int total = userInfoMapper.selectCountUserInfoByParams(params);
		
		return new Page<UserInfo>(total, list);
	}

	/**
	 * 添加会员信息
	 */
	@Transactional
	@Override
	public void add(UserInfo userInfo) throws Exception {
		userInfoMapper.add(userInfo);
	}

	/**
	 *  查询手机号或会员账户是否已存在
	 */
	@Override
	public UserInfo findUserInfoByPhoneOrUserName(Map<String, Object> params) throws Exception {
		return userInfoMapper.findUserInfoByPhoneOrUserName(params);
	}

	/**
	 * 根据ID修改密码
	 */
	@Override
	public void updatePwd(String pwd,Long id) throws Exception {
		userInfoMapper.updatePwd(pwd, id);
	}

	/**
	 * 根据ID修改真是姓名
	 */
	@Override
	public void updateRealName(String realName,Long id) throws Exception {
		userInfoMapper.updateRealName(realName, id);
	}

	/**
	 * 修改角色信息
	 * @param userInfo
	 * @throws Exception
	 */
	@Override
	public void updateByid(UserInfo userInfo) throws Exception {
		userInfoMapper.updateByid(userInfo);
	}

	/**
	 * 根据ID禁止用户登录
	 * @param ids
	 * @throws Exception
	 */
	@Override
	public void fordenUserInfoById(Long[] ids) throws Exception {
		userInfoMapper.fordenUserInfoById(ids);
	}

	/**
	 * 根据id启用用户登录
	 * @param ids
	 * @throws Exception
	 */
	@Override
	public void openUserInfoById(Long[] ids) throws  Exception {
		userInfoMapper.openUserInfoById(ids);
	}

	/**
	 * 根据ID批量删除用户信息
	 * @param ids
	 * @throws Exception
	 */
	@Override
	public void delUserInfo(Long[] ids) throws Exception {
		userInfoMapper.delUserInfo(ids);
	}


	/**
	 * 重置用户密码信息
	 * @param rowid
	 * @throws Exception
	 */
	@Override
	public void resUserInfoById(Long rowid) throws  Exception {
		userInfoMapper.resUserInfoById(rowid);
	}

	/**
	 * 效验用户是否已经存在
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserInfo existUserName(String userName) throws Exception {
		return userInfoMapper.existUserName(userName);
	}

	/**
	 * 根据id查找用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserInfo getUserInfoById(Long id) throws Exception {
		return userInfoMapper.selectUserInfoById(id);
	}



}

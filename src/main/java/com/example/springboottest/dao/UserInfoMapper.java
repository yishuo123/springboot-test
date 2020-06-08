package com.example.springboottest.dao;

import com.example.springboottest.bean.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 会员信息Mapper接口
 * @author lizy
 * 2016年11月27日
 */
@Mapper
public interface UserInfoMapper {

	/**
	 * 用户登录
	 * @param userName	用户名	
	 * @param pwd		密码
	 * @return			用户信息
	 * @throws Exception
	 */
	List<UserInfo> findUserInfoByUserNameAndPwd(@Param("userName") String userName, @Param("pwd") String pwd) throws Exception;
	
	/**
	 * 根据条件分页查询会员信息
	 * @param params	查询条件
	 * @return
	 * @throws Exception
	 */
	List<UserInfo> selectUserInfoByParams(Map<String, Object> params)throws Exception;
	
	/**
	 * 根据条件查询总条件用于分页
	 * @param params	查询条件
	 * @return
	 * @throws Exception
	 */
	int selectCountUserInfoByParams(Map<String, Object> params)throws Exception;
	
	/**
	 * 添加会员信息
	 * @param userInfo		会员信息
	 * 
	 */
	void add(UserInfo userInfo)throws Exception;

	/**
	 * 根据手机号码查询用户是否存在
	 * @return
	 * @throws Exception
	 */
	UserInfo findUserInfoByPhoneOrUserName(Map<String, Object> params) throws Exception;

	/**
	 * 根据ID修改密码
	 * @param id	id
	 * @param pwd
	 */
	void updatePwd(@Param("pwd") String pwd, @Param("id") Long id)throws Exception;

	/**
	 * 根据ID修改真实姓名
	 * @param id	id
	 * @param realName
	 */
	void updateRealName(@Param("realName") String realName, @Param("id") Long id)throws Exception;

	/**
	 * 修改角色信息
	 * @param userInfo
	 * @throws Exception
	 */
	void updateByid(UserInfo userInfo) throws Exception;

	/**
	 *根据ID禁止用户登录
	 * @param ids
	 * @throws Exception
	 */

	void fordenUserInfoById(Long[] ids) throws Exception;

	/**
	 *根据ID启用用户登录
	 * @param ids
	 * @throws Exception
	 */
	void openUserInfoById(Long[] ids) throws  Exception;

	/**
	 * 根据ID批量删除用户信息
	 * @param ids
	 * @throws Exception
	 */
	void delUserInfo(Long[] ids)throws Exception;

	/**
	 *重置用户密码信息
	 * @param rowid
	 * @throws Exception
	 */
	void resUserInfoById(Long rowid) throws  Exception;

	/**
	 * 效验用户是否已经存在
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	UserInfo existUserName(String userName) throws Exception;


	/**
	 * 根据id查找用户信息
	 * @param id
	 * @return
	 */
	UserInfo selectUserInfoById(@Param("id") Long id) throws Exception;
}

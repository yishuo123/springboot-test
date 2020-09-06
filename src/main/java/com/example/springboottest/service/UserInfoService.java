package com.example.springboottest.service;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.util.Page;

import java.util.Map;

/**
 * 会员信息Service层接口
 *
 * @author lizy
 * 2016年11月27日
 */
public abstract interface UserInfoService {

    /**
     * 用户登录
     *
     * @param userName 登录账户
     * @param pwd      密码
     * @return
     * @throws Exception
     */
    UserInfo findUserInfoByUserNameAndPwd(String userName, String pwd) throws Exception;

    /**
     * 根据条件分页查询会员信息
     *
     * @param params 查询条件
     * @return
     * @throws Exception
     */
    Page<UserInfo> findUserInfoPages(Map<String, Object> params) throws Exception;

    /**
     * 添加会员信息
     *
     * @param userInfo 会员信息
     * @throws Exception
     */
    void add(UserInfo userInfo) throws Exception;

    /**
     * 查询手机号或用户名是否已存在
     *
     * @param params 查询参数
     * @throws Exception
     * @return 不存在返回0
     */
    UserInfo findUserInfoByPhoneOrUserName(Map<String, Object> params) throws Exception;

    /**
     * 根据ID修改密码
     *
     * @param id  id
     * @param pwd
     */
    void updatePwd(String pwd, Long id) throws Exception;

    /**
     * 根据ID修改真实姓名
     *
     * @param id       id
     * @param realName
     */
    void updateRealName(String realName, Long id) throws Exception;

    /**
     * 修改角色信息
     *
     * @param userInfo
     * @throws Exception
     */
    void updateByid(UserInfo userInfo) throws Exception;

    /**
     * 根据id禁止用户登录
     *
     * @param ids
     * @throws Exception
     */
    void fordenUserInfoById(Long[] ids) throws Exception;

    /**
     * 根据id启用用户登录
     *
     * @param ids
     * @throws Exception
     */
    void openUserInfoById(Long[] ids) throws Exception;

    /**
     * 根据ID批量删除用户信息
     *
     * @param ids
     * @throws Exception
     */
    void delUserInfo(Long[] ids) throws Exception;

    /**
     * 重置用户密码信息
     *
     * @param rowid
     * @throws Exception
     */
    void resUserInfoById(Long rowid) throws Exception;

    /**
     * 验证用户名是否存在
     *
     * @param userName
     * @return
     * @throws Exception
     */
    UserInfo existUserName(String userName) throws Exception;

    /**
     * 根据id查找用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo getUserInfoById(Long id) throws Exception;


}

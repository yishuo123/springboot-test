package com.example.springboottest.shiro;

import com.example.springboottest.model.User;
import com.example.springboottest.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义的realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 执行授权的逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权的逻辑");

        //给资源执行授权的操作
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        //动态连接数据库来实行授权
        // 获取当前用户的id
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User dbUser = userService.getById(user.getId());

        // 将查询出来的结果动态放在
        info.addStringPermission(dbUser.getPeralm());
        return info;
    }


    /**
     * 执行认证的逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证的逻辑");


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByName(token.getUsername());

        if (user == null) {
            // 用户不存在 抛出异常
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo(user, user.getPassWord(), "");
    }
}

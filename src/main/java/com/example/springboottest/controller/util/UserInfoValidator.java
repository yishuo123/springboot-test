package com.example.springboottest.controller.util;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UserInfo form 表单校验
 *
 * @author lizy
 * 2016年12月1日
 */
@Component
public class UserInfoValidator {

    /**
     * 会员注册表单校验
     *
     * @param userInfo        会员信息
     * @param userInfoService
     * @return
     * @throws Exception
     */
    public static boolean validator(UserInfo userInfo, UserInfoService userInfoService) throws Exception {

        Map<String, Object> param = new HashMap<String, Object>();

        //校验手机号码不能为空 && 手机号码没有在数据库中存在
        String phone = userInfo.getPhone();

        param.put("phone", phone);

        if (StringUtils.isBlank(phone)) {
            return false;

        } else if (userInfoService.findUserInfoByPhoneOrUserName(param) != null) {
            return false;
        }


        //校验会员账户不能为空并且会员账户不存在
        String userName = userInfo.getUserName();

        param = new HashMap<String, Object>();
        param.put("userName", userName);

        if (StringUtils.isBlank(userName)) {
            return false;
        } else if (userInfoService.existUserName(userName) != null) {
            return false;
        }


        //校验真实姓名不能为空并且为汉字
        String realName = userInfo.getRealName();

        if (StringUtils.isBlank(realName)) {
            return false;
        } else if (!realNameValidator(realName)) {
            return false;
        }

        return true;
    }

    /**
     * 校验真实姓名格式是否正确
     *
     * @param realName 真实姓名
     * @return
     * @throws Exception
     */
    public static boolean realNameValidator(String realName) throws Exception {
        String pat = "[\\u4E00-\\u9FBF]+";
        Pattern p = Pattern.compile(pat);            // 实例化Pattern类
        Matcher m = p.matcher(realName);            // 验证内容是否合法

        if (m.matches())
            return true;

        return false;
    }
}
	


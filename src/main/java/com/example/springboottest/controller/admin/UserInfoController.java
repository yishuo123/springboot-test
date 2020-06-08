package com.example.springboottest.controller.admin;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.controller.util.UserInfoValidator;
import com.example.springboottest.core.ResultValue;
import com.example.springboottest.core.session.SessionFactory;
import com.example.springboottest.core.util.StringUtil;
import com.example.springboottest.service.UserInfoService;
import com.example.springboottest.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 会员信息controller
 *
 * @author lizy
 * 2016年11月27日
 */
@RequestMapping("/admin/userInfo")
@Controller
public class UserInfoController {

    private Logger log = Logger.getLogger(UserInfoController.class);

    @Autowired
    protected UserInfoService userInfoService;

    /**
     * 跳转查询会员信息页面
     *
     * @return
     */
    @RequestMapping("/")
    public String findUserInfo() {

        return "admin/user/userInfo";
    }

    /**
     * 跳转会员资料页面页面
     *
     * @return
     */
    @RequestMapping(value = "/profile")
    public String profile() {
        return "user/profile";
    }


    /**
     * 根据条件分页查询会员信息
     *
     * @param userName 会员账户
     * @param phone    手机号
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Page<UserInfo> findUserInfo(HttpServletRequest request,
                                       @RequestParam(value = "userName", required = false) String userName,
                                       @RequestParam(value = "phone", required = false) String phone,
                                       @RequestParam(value = "status", required = false) String status,
                                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        log.info("findUserInfo params: userName=" + userName + ", phone:" + phone + ", page=" + page + ", rows=" + rows);
        Page<UserInfo> pages = new Page<UserInfo>();

        try {
            UserInfo userInfo = SessionFactory.getSessionUser(request);

            Map<String, Object> params = getMapParams(userInfo, userName, phone,status, page, rows);

            pages = userInfoService.findUserInfoPages(params);
            pages.setPageIndex(page);
            pages.setMaxResult(rows);

        } catch (Exception e) {
            log.error("findUserInfo error:", e);
        }

        return pages;
    }

    private Map<String, Object> getMapParams(UserInfo userInfo, String userName, String phone,String status, Integer page, Integer rows) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (!"admin".equals(userInfo.getUserName())) {
            params.put("createBy", userInfo.getUserName());
        }
        if (StringUtils.isNotBlank(userName)) {
            params.put("userName", "%" + userName + "%");
        }

        if (StringUtils.isNotBlank(phone)) {
            params.put("phone", "%" + phone + "%");
        }

        if (StringUtils.isNotBlank(status) && !"all".equals(status)) {
            params.put("status",  status );
        }

        params.put("page", (page - 1) * rows);
        params.put("rows", rows);

        return params;

    }

    /**
     * 校验手机号是否存在
     *
     * @param phone 手机号
     * @return 存在返回1，否则返回 0
     */
    @RequestMapping("/existPhone")
    @ResponseBody
    public boolean existPhone(
            @RequestParam(value = "id", required = true, defaultValue = "0") Long id,
            @RequestParam(value = "phone", required = true) String phone) {

        try {
            if (StringUtils.isNotBlank(phone)) {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("phone", phone);
                UserInfo userInfo = userInfoService.findUserInfoByPhoneOrUserName(param);
                if (userInfo != null) {

                    if (id != 0) {  //如果用户不为0，代表编辑用户，判断当前id是否是userID，是返回true 否则false
                        return id == userInfo.getId() ? true : false;
                    } else {        // userInfo 不为null, id为0 说明数据
                        return false;
                    }
                }else {
                    return true;
                }
            } else {
                return true;
            }

        } catch (Exception e) {
            log.error("existPhone error:", e);
        }

        return false;
    }

    /**
     * 校验用户名是否存在
     *
     * @param userName 用户名
     * @return 存在返回1，否则返回 0
     */
    @RequestMapping("/checkUserName")
    @ResponseBody
    public boolean checkUserName(
            @RequestParam(value = "id", required = true, defaultValue = "0") Long id,
            @RequestParam(value = "userName", required = true) String userName) {

        try {
            if (StringUtils.isNotBlank(userName)) {
                Map<String, Object> param = new HashMap<String, Object>();

                UserInfo userInfo = userInfoService.existUserName(userName);

                if (userInfo != null) {

                    if (id != 0) {  //如果用户不为0，代表编辑用户，判断当前id是否是userID，是返回true 否则false
                        return id == userInfo.getId() ? true : false;
                    } else {        // userInfo 不为null, id为0 说明数据
                        return false;
                    }
                }else {
                    return true;
                }
            } else {
                return true;
            }


        } catch (Exception e) {
            log.error("checkUserName error:", e);
        }

        return false;
    }


    /**
     * 添加用户信息
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultValue addUserInfo(HttpServletRequest request,
                                   UserInfo userInfo) {

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);
        try {

            if (userInfo != null) {

                UserInfo sessionUser = SessionFactory.getSessionUser(request);
                Long sysTime = System.currentTimeMillis();
                Date date = new Date(sysTime);
                String createUser = sessionUser.getUserName();


                //userInfo.setModifyBy(createUser);            //添加修改人
                //userInfo.setModifyDate(date);                //添加修改时间

                if (userInfo.getId() != null) {

                    //校验会员账户不能为空
                    String userName = userInfo.getUserName();
                    Map<String, Object> param = new HashMap<String, Object>();
                    param = new HashMap<String, Object>();
                    param.put("userName", userName);

                    if (StringUtils.isBlank(userName)) {
                        resultValue.setMessage("用户名不能为空");
                        return resultValue;
                    }

                    //校验真实姓名不能为空并且为汉字
                    String realName = userInfo.getRealName();

                    if (StringUtils.isBlank(realName)) {
                        resultValue.setMessage("用户名不能为空");
                        return resultValue;
                    } else if (!UserInfoValidator.realNameValidator(realName)) {
                        resultValue.setMessage("用户名为汉字");
                        return resultValue;
                    }


                    userInfo.setModifyBy(createUser);                        //创建人
                    userInfo.setModifyDate(date);                            //创建时间

                    userInfoService.updateByid(userInfo);

                    resultValue.setState(ResultValue._SUCCESS);

                    return resultValue;
                    //}
                } else {

                    //校验提交的form表单
                    boolean flag = UserInfoValidator.validator(userInfo, userInfoService);

                    if (flag) {
                        //md5密码加密
                        String inntpwd = "111111";
                        String pwdMD5 = StringUtil.md5(inntpwd);

                        userInfo.setId(userInfo.getId());            //生成UUID
                        userInfo.setPassword(pwdMD5);                            //密碼
                        userInfo.setStatus(UserInfo.STATUS_1);                    //设置会员状态
                        userInfo.setCreateBy(createUser);                        //创建人
                        userInfo.setCreateDate(date);                            //创建时间

                        userInfoService.add(userInfo);

                        resultValue.setState(ResultValue._SUCCESS);

                        return resultValue;
                    } else {
                        resultValue.setMessage("注册失败，非法注册");
                        return resultValue;
                    }
                }

            } else {
                resultValue.setMessage("操作失败，非法操作");
                return resultValue;
            }

        } catch (Exception e) {
            log.error("addUserInfo error:", e);

            resultValue.setMessage("注册失败，系统错误");
        }

        return resultValue;
    }

    /**
     * 根据ID修改密码
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public ResultValue updatePwd(HttpServletRequest request,
                                 @RequestParam(value = "xpwd") String pwd) {

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);

        try {
            UserInfo sessionUser = SessionFactory.getSessionUser(request);

            if (StringUtils.isNotBlank(pwd)) {

                userInfoService.updatePwd(StringUtil.md5(pwd),sessionUser.getId() );

                SessionFactory.removeAllSession(request);

                resultValue.setState(ResultValue._SUCCESS);

                return resultValue;
            } else {
                resultValue.setMessage(ResultValue.ERROR_MSG_2);

                return resultValue;
            }

        } catch (Exception e) {
            log.error("updatePwd error:", e);

            resultValue.setMessage(ResultValue.ERROR_MSG_3);
        }

        return resultValue;
    }


    /**
     * 根据ID禁止用户登录
     *
     * @param ids 要禁止的id
     * @return
     */
    @RequestMapping(value = "/fordenUserInfoById")
    @ResponseBody
    public ResultValue fordenUserInfoById(
            @RequestParam(value = "ids", required = true) Long[] ids) {
        log.info("fordenUserInfoById ids=" + ids);

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);

        try {
            if (ids != null && ids.length > 0) {

                userInfoService.fordenUserInfoById(ids);

                resultValue.setState(ResultValue._SUCCESS);
                return resultValue;
            } else {

                resultValue.setMessage(ResultValue.ERROR_MSG_2);
                return resultValue;
            }

        } catch (Exception e) {
            log.error("delRoleInfo error:", e);

            resultValue.setMessage(ResultValue.ERROR_MSG_1);
        }

        return resultValue;
    }

    /**
     * 根据ID启用用户登录
     *
     * @param ids 要启用的id
     * @return
     */
    @RequestMapping(value = "/openUserInfoById")
    @ResponseBody
    public ResultValue openUserInfoById(
            @RequestParam(value = "ids", required = true) Long[] ids) {
        log.info("fordenUserInfoById ids=" + ids);

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);

        try {
            if (ids != null) {

                userInfoService.openUserInfoById(ids);

                resultValue.setState(ResultValue._SUCCESS);
                return resultValue;
            } else {

                resultValue.setMessage(ResultValue.ERROR_MSG_2);
                return resultValue;
            }

        } catch (Exception e) {
            log.error("delRoleInfo error:", e);

            resultValue.setMessage(ResultValue.ERROR_MSG_1);
        }

        return resultValue;
    }

    /**
     * 根据ID批量删除角色
     *
     * @param ids 要删除的id
     * @return
     */
    @RequestMapping(value = "/delUserInfo")
    @ResponseBody
    public ResultValue delUserInfo(
            @RequestParam(value = "ids", required = true) Long[] ids) {
        log.info("delRoleInfo ids=" + ids);

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);

        try {
            if (ids != null && ids.length > 0) {

                userInfoService.delUserInfo(ids);

                resultValue.setState(ResultValue._SUCCESS);
                return resultValue;
            } else {

                resultValue.setMessage(ResultValue.ERROR_MSG_2);
                return resultValue;
            }

        } catch (Exception e) {
            log.error("delRoleInfo error:", e);

            resultValue.setMessage(ResultValue.ERROR_MSG_1);
        }

        return resultValue;
    }

    /**
     * 重置用户密码信息
     *
     * @param rowid 要启用的id
     * @return
     */
    @RequestMapping(value = "/resUserInfoById")
    @ResponseBody
    public ResultValue resUserInfoById(
            @RequestParam(value = "rowid", required = true) Long rowid) {
        log.info("fordenUserInfoById rowid=" + rowid);

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);

        try {
            if (rowid != null) {

                userInfoService.resUserInfoById(rowid);

                resultValue.setState(ResultValue._SUCCESS);
                return resultValue;
            } else {

                resultValue.setMessage(ResultValue.ERROR_MSG_2);
                return resultValue;
            }

        } catch (Exception e) {
            log.error("delRoleInfo error:", e);

            resultValue.setMessage(ResultValue.ERROR_MSG_1);
        }

        return resultValue;
    }

    /**
     * 校验旧密码是否正确
     * @param request
     * @return
     */
    @RequestMapping(value="/checkPwd")
    @ResponseBody
    public boolean checkPwd(HttpServletRequest request,
                            @RequestParam(value = "lpwd") String pwd){

        try{
            UserInfo sessionUser = SessionFactory.getSessionUser(request);

            if(StringUtil.md5(pwd).equals(sessionUser.getPassword())){
                return true;
            }
        }catch(Exception e){
            log.error("checkPwd error:", e);
        }

        return false;
    }

    /**
     * 根据ID修改真实姓名
     */
    @RequestMapping(value = "/updateRealName", method = RequestMethod.POST)
    @ResponseBody
    public ResultValue updateRealName(HttpServletRequest request,
                                 @RequestParam(value = "realName") String realName) {

        ResultValue resultValue = new ResultValue();
        resultValue.setState(ResultValue._ERROR);

        try {
            UserInfo sessionUser = SessionFactory.getSessionUser(request);

            if (StringUtils.isNotBlank(realName)) {

                userInfoService.updateRealName(realName,sessionUser.getId() );

                UserInfo userInfo = userInfoService.getUserInfoById(sessionUser.getId());

                SessionFactory.setSessionUser(request,userInfo);

                resultValue.setState(ResultValue._SUCCESS);

                resultValue.setMessage(userInfo.getRealName());

                return resultValue;
            } else {
                resultValue.setMessage(ResultValue.ERROR_MSG_2);

                return resultValue;
            }

        } catch (Exception e) {
            log.error("updatePwd error:", e);

            resultValue.setMessage(ResultValue.ERROR_MSG_3);
        }

        return resultValue;
    }


}

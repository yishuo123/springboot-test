package com.example.springboottest.controller.admin;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.core.ResultValue;
import com.example.springboottest.core.session.SessionFactory;
import com.example.springboottest.core.util.StringUtil;
import com.example.springboottest.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录Controller
 * @author lizy
 * 2016年11月27日
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	protected Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	protected UserInfoService userInfoService;
	
	/**
	 * 跳转登录页面
	 * @return
	 */
	@RequestMapping("")
	public String login(){
		return "admin/login";
	}
	
	/**
	 * 用户登录校验
	 * @param userName	用户名
	 * @param pwd	·	密码
	 * @return
	 */
	@RequestMapping("/submitLogin")
	@ResponseBody
	public ResultValue submit(HttpServletRequest request,
							  @RequestParam(value="userName", required =false) String userName,
							  @RequestParam(value="pwd", required =false) String pwd){
		log.info("submit params: userName="+ userName);
		
		ResultValue resultValue = new ResultValue();
		resultValue.setState(ResultValue._ERROR);
		
		try{
			
			//判断用户名或密码是否为空
			if(!checkParams(userName, pwd)){
				resultValue.setMessage("账户名与密码不匹配，请重新输入");
				
				return resultValue;
			}
			
			UserInfo userInfo = userInfoService.findUserInfoByUserNameAndPwd(userName, StringUtil.md5(pwd));
			
			if(userInfo != null){
				//会员是否禁用
				if(userInfo.getStatus().equals(UserInfo.STATUS_2)){
					resultValue.setMessage("会员账户已禁用，请联系管理员");
					
					return resultValue;
				}

				//登陆成功,设置session
				SessionFactory.setSessionUser(request, userInfo);
				resultValue.setState(ResultValue._SUCCESS);
				
			}else{
				resultValue.setMessage("账户名与密码不匹配，请重新输入");
				
			}
			
			
		}catch (Exception e){
			log.error("submit error: "+ e);
			
			resultValue.setMessage("登录失败，请重新登录或联系管理员");
		}
		
		return resultValue;
		
	}
	
	/**
	 * 校验登录名或者登录密码是否为空	
	 * @param userName	登陆账户
	 * @param pwd		密码
	 * @return
	 */
	private boolean checkParams(String userName, String pwd){
		if(StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(pwd)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/out")
	public String logOut(HttpServletRequest request){
		SessionFactory.removeAllSession(request);
		
		return "redirect:/login";
	}
}

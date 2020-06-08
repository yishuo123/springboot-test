package com.example.springboottest.controller.admin;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.core.session.SessionFactory;
import com.example.springboottest.service.MenuInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 后台主页面
 *
 * @author lizy
 * 2016年10月30日
 */

@Controller
@RequestMapping(value = "/admin")
public class MainController {
	private Logger log = Logger.getLogger(MainController.class);
	
	@Resource
	private MenuInfoService menuInfoService;
	
	@RequestMapping("")
	public String index(HttpServletRequest request){
//		String menuHtml = MenuUtil.getMenu();
//		
//		request.getSession().setAttribute("menuHtml", menuHtml);
		return "admin/index";
	}
	
	/**
	 * 根据用户角色获取菜单
	 * @param request	
	 * @return
	 */
	@RequestMapping(value = "/getMenu", produces = "application/html; charset=utf-8")
	@ResponseBody
	public String getMenu(HttpServletRequest request ){

		String roleId = "";
		try{
			UserInfo userInfo = SessionFactory.getSessionUser(request);
			return menuInfoService.getMenu(userInfo.getRoleId());
			
		}catch(Exception e){
			log.error("getMenu roleId="+ roleId +", error:", e);
		}
		
		return "";
	}
	
	
}

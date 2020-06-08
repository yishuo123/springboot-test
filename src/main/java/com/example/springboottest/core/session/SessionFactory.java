package com.example.springboottest.core.session;


import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.core.Const;

import javax.servlet.http.HttpServletRequest;

public class SessionFactory {

	/**
	 * 获取当前登录用户的Session
	 */
	public static UserInfo getSessionUser(HttpServletRequest request) {
		return (UserInfo) request.getSession().getAttribute(Const.SESSION_USERINFO);
	}

	/**
	 * 添加当前登录的用户Session
	 * @param request
	 * @param UserInfo
	 */
	public static void setSessionUser(HttpServletRequest request, UserInfo UserInfo) {
		request.getSession().setAttribute(Const.SESSION_USERINFO, UserInfo);
	}

	/**
	 * 清空所有session
	 */
	public static void removeAllSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	/**
	 * 清空某一个session
	 * @param request
	 * @param sessionName	要清空的session名字
	 */
	public static void removeSession(HttpServletRequest request, String sessionName){
		request.getSession().removeAttribute(sessionName);
	}
	
	/**
	 * 清空当前登录的用户session
	 * @param request
	 */
	public static void removeSession(HttpServletRequest request){
		request.getSession().removeAttribute(Const.SESSION_USERINFO);
	}
}

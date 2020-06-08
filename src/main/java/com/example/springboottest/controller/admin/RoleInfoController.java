package com.example.springboottest.controller.admin;

import com.example.springboottest.bean.model.RoleInfo;
import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.core.ResultValue;
import com.example.springboottest.core.session.SessionFactory;
import com.example.springboottest.service.RoleInfoService;
import com.example.springboottest.service.RoleMenuInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色信息Controller
 * @author lizy
 * 2016年11月28日
 */
@RequestMapping("/admin/roleInfo")
@Controller
public class RoleInfoController {

	private Logger log = Logger.getLogger(RoleInfoController.class);
	
	@Resource
	private RoleInfoService roleInfoService;
	
	@Resource
	private RoleMenuInfoService roleMenuInfoService;
	/**
	 * 跳转查询角色信息页面
	 * @return
	 */
	@RequestMapping("/")
	public String findUserInfo(){
		
		return "admin/user/roleInfo";
	}
	/**
	 * 获取角色信息
	 * @return
	 */
	@RequestMapping("/get")
	@ResponseBody
	public List<RoleInfo> getRoleInfo(HttpServletRequest request,
									  @RequestParam(value="roleName", required = false) String roleName){
		
		try {

 			UserInfo userInfo = SessionFactory.getSessionUser(request);
			List<RoleInfo> roleList = roleInfoService.getRoleInfo(roleName);
			return roleList;
			
		} catch (Exception e) {
			log.error("getRoleInfo error : ", e);
		}
		return null;
	}
	
	/**
	 * 根据角色ID查询角色授权信息
	 * @param request
	 * @param roleId 角色ID
	 * @return
	 */
	@RequestMapping(value = "/roleMenu" , produces = "application/html; charset=utf-8")
	@ResponseBody
	public String roleMenuHtml(HttpServletRequest request,
		@RequestParam(value = "roleId", required = true)Long roleId ){
		log.info("roleMenuHtml params:roleId="+roleId);
		
		String tableHtml = "";
		try{
			String path = request.getContextPath();
			
			if(roleId != null){
				tableHtml = roleMenuInfoService.createTree(roleId, path);
			}
			
		}catch(Exception e){
			log.error("roleMenuHtml error:", e);
		}
		
		return tableHtml;
		
	}
	
	/**
	 * 为角色添加权限
	 * @param roleId	角色ID
	 * @param menuIds	权限ID
	 * @return
	 */
	@RequestMapping(value = "addRoleMenu", method = RequestMethod.POST)
	@ResponseBody
	public ResultValue addRoleMenu(
		@RequestParam(value = "roleId", required = true)Long roleId,
		@RequestParam(value = "menuIds", required = true)Long[] menuIds){
		log.info("addRoleMenu params:roleId="+ roleId +", menuIds="+ menuIds);
		
		ResultValue resultValue = new ResultValue();
		resultValue.setState(ResultValue._ERROR);
		try{
			if(roleId != null){
				
				roleMenuInfoService.addRoleMenu(roleId, menuIds);
				
				resultValue.setState(ResultValue._SUCCESS);
				return resultValue;
			}else{
				resultValue.setMessage("保存失败，角色为空");
				return resultValue;
			}
		
			
		}catch(Exception e){
			log.error("addRoleMenu error:", e);
			
			resultValue.setMessage(ResultValue.ERROR_MSG_1);
		}
		
		
		return resultValue;
	}

	/**
	 * 添加角色信息
	 * @param roleInfo	添加角色信息
	 * @return   roleInfoService.add(roleInfo);
	 * roleInfoService.update(roleInfo);
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultValue addRoleInfo(RoleInfo roleInfo){
		log.info("roleInfo:"+roleInfo.toString());

		ResultValue resultValue = new ResultValue();
		resultValue.setState(ResultValue._ERROR);

		try{
			if(roleInfo != null){
				//校验菜单信息
				if(checkRoleInfo(roleInfo)){
					//新增or修改
					if(roleInfo.getId() == null ){

						roleInfoService.add(roleInfo);
					}else{
						roleInfoService.update(roleInfo);
					}

					resultValue.setState(ResultValue._SUCCESS);
					return resultValue;

				}else{
					resultValue.setMessage(ResultValue.ERROR_MSG_ADD);
					return resultValue;
				}

			}

			resultValue.setMessage(ResultValue.ERROR_MSG_2);
			return resultValue;

		}catch(Exception e){
			log.error("addRoleInfo error:", e);

			resultValue.setMessage(ResultValue.ERROR_MSG_1);
		}

		return resultValue;
	}

	/**
	 * 检测菜单信息
	 * @param roleInfo	菜单信息
	 * @return
	 * @throws Exception
	 */
	private boolean checkRoleInfo(RoleInfo roleInfo)throws Exception{

		if(StringUtils.isBlank(roleInfo.getRoleName()) ||
				roleInfo.getRoleCode() == null){
			return false;
		}

		return true;
	}

	/**
	 * 根据ID批量删除角色
	 * @param ids	要删除的id
	 * @return
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public ResultValue delRoleInfo(
		@RequestParam(value= "ids", required = true)Long[] ids){
		log.info("delRoleInfo ids="+ids);

		ResultValue resultValue = new ResultValue();
		resultValue.setState(ResultValue._ERROR);

		try{
			if(ids != null && ids.length > 0){

				roleInfoService.del(ids);

				resultValue.setState(ResultValue._SUCCESS);
				return resultValue;
			}else{

				resultValue.setMessage(ResultValue.ERROR_MSG_2);
				return resultValue;
			}

		}catch(Exception e){
			log.error("delRoleInfo error:", e);

			resultValue.setMessage(ResultValue.ERROR_MSG_1);
		}

		return resultValue;
	}

	/**
	 * 校验角色名称是否存在
	 *
	 * @param roleName 用户名
	 * @return 存在返回1，否则返回 0
	 */
	@RequestMapping("/checkRoleName")
	@ResponseBody
	public boolean checkRoleName(
			@RequestParam(value = "id", required = true, defaultValue = "0") Long id,
			@RequestParam(value = "roleName", required = true) String roleName) {

		try {
			if (StringUtils.isNotBlank(roleName)) {
				Map<String, Object> param = new HashMap<String, Object>();

				RoleInfo roleInfo = roleInfoService.existroleName(roleName);

				if (roleInfo != null) {

					if (id != 0) {  //如果用户不为0，代表编辑用户，判断当前id是否是userID，是返回true 否则false
						return id == roleInfo.getId() ? true : false;
					} else {        // roleInfo 不为null, id为0 说明数据
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

}

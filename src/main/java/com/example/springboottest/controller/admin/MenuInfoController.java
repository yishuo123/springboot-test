package com.example.springboottest.controller.admin;

import com.example.springboottest.bean.model.MenuInfo;
import com.example.springboottest.core.ResultValue;
import com.example.springboottest.service.MenuInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单权限Controller
 * @author lizy
 * 2016年12月4日
 */
@RequestMapping("/admin/menuInfo")
@Controller
public class MenuInfoController {

	private Logger log = Logger.getLogger(RoleInfoController.class);
	
	@Resource
	private MenuInfoService menuInfoService;
	
	/**
	 * 跳转查询菜单信息页面
	 * @return
	 */
	@RequestMapping("/")
	public String findUserInfo(){
		
		return "admin/user/menuInfo";
	}
	
	/**
	 * 获取菜单信息
	 * @return
	 */
	@RequestMapping("/find")
	@ResponseBody
	public List<MenuInfo> findMenuInfo(HttpServletRequest request,
									   @RequestParam(value="menuName", required = false) String menuName){
		
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("menuName", "%"+menuName+"%");

			return menuInfoService.findMenuInfoByParams(params);
			
		} catch (Exception e) {
			log.error("findMenuInfo error : ", e);
		}
		return null;
	}
	
	/**
	 * 获取一级菜单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findParent")
	@ResponseBody
	public List<MenuInfo> findMenuInfoParent(){
		
		List<MenuInfo> menuInfoList = new ArrayList<MenuInfo>();
		try {

			menuInfoList =  menuInfoService.findMenuInfoParent();

		} catch (Exception e) {
			log.error("findMenuInfoParent error:", e);
		}
		
		return menuInfoList;
	}
	
	/**
	 * 添加菜单信息
	 * @param menuInfo	添加菜单信息
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultValue addMenuInfo(MenuInfo menuInfo){
		log.info("menuInfo:"+menuInfo.toString());
		
		ResultValue resultValue = new ResultValue();
		resultValue.setState(ResultValue._ERROR);
		
		try{
			if(menuInfo != null){
				//校验菜单信息
				if(checkMenuInfo(menuInfo)){
					//新增or修改
					if(menuInfo.getId() == null){
						
						menuInfoService.addMenuInfo(menuInfo);
					}else{
						menuInfoService.updateMenuInfo(menuInfo);
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
			log.error("addMenuInfo error:", e);
			
			resultValue.setMessage(ResultValue.ERROR_MSG_1);
		}
		
		return resultValue;
	}
	
	/**
	 * 检测菜单信息
	 * @param menuInfo	菜单信息
	 * @return
	 * @throws Exception
	 */
	private boolean checkMenuInfo(MenuInfo menuInfo)throws Exception{
		
		if(StringUtils.isBlank(menuInfo.getMenuName())){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据ID批量删除菜单
	 * @param ids	要删除的id
	 * @return
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public ResultValue delMenuInfo(
		@RequestParam(value= "ids", required = true)String[] ids){
		log.info("delMenuInfo ids="+ids);
		
		ResultValue resultValue = new ResultValue();
		resultValue.setState(ResultValue._ERROR);
		
		try{
			if(ids != null && ids.length > 0){
				
				menuInfoService.delMenuInfo(ids);
				
				resultValue.setState(ResultValue._SUCCESS);
				return resultValue;
			}else{	
				
				resultValue.setMessage(ResultValue.ERROR_MSG_2);
				return resultValue;
			}
			
		}catch(Exception e){
			log.error("delMenuInfo error:", e);
			
			resultValue.setMessage(ResultValue.ERROR_MSG_1);
		}
		
		return resultValue;
	}
}


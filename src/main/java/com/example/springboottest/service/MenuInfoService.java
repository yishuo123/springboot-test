package com.example.springboottest.service;


import com.example.springboottest.bean.model.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * 菜单信息 Service层
 *
 * @author lizy
 * 2016年12月4日
 */
public interface MenuInfoService {

    /**
     * 根据条件获取全部菜单权限
     *
     * @return
     */
    List<MenuInfo> findMenuInfoByParams(Map<String, Object> params) throws Exception;

    /**
     * 获取所有父级节点的菜单
     *
     * @throws Exception
     * @return 返回父级节点
     */
    List<MenuInfo> findMenuInfoParent() throws Exception;

    /**
     * 添加菜单信息
     *
     * @param menuInfo 菜单信息
     * @throws Exception
     */
    void addMenuInfo(MenuInfo menuInfo) throws Exception;

    /**
     * 修改菜单信息
     *
     * @param menuInfo 菜单信息
     * @throws Exception
     */
    void updateMenuInfo(MenuInfo menuInfo) throws Exception;

    /**
     * 批量删除菜单信息
     *
     * @param ids 菜单信息ID
     * @throws Exception
     */
    void delMenuInfo(String[] ids) throws Exception;

    /**
     * 根据角色查询封装菜单
     *
     * @param roleId 角色ID
     * @return
     * @throws Exception
     */
    String getMenu(Long roleId) throws Exception;
}

package com.example.springboottest.service;

/**
 * 角色权限中间表Service层接口
 *
 * @author lizy
 * 2016年12月10日
 */
public interface RoleMenuInfoService {

    /**
     * 根据角色ID和菜单ID查询中间表信息
     * @param roleId    角色ID
     * @param menuId    菜单ID
     * @return
     * @throws Exception
     */
    //int findRoleMenuInfoByRoleIdAndMenuId(String roleId, String menuId)throws Exception;

    /**
     * 根据角色信息生成菜单授权书
     *
     * @param roleId 角色信息
     * @return
     * @throws Exception
     */
    String createTree(Long roleId, String path) throws Exception;

    /**
     * 为角色绑定权限
     *
     * @param roleId  角色ID
     * @param menuIds 权限ID
     * @throws Exception
     */
    void addRoleMenu(Long roleId, Long[] menuIds) throws Exception;


}

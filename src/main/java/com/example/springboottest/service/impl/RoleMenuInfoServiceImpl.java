package com.example.springboottest.service.impl;

import com.example.springboottest.bean.model.MenuInfo;
import com.example.springboottest.bean.model.RoleMenuInfo;
import com.example.springboottest.dao.MenuInfoMapper;
import com.example.springboottest.dao.RoleMenuInfoMapper;
import com.example.springboottest.service.RoleMenuInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限中间表Service层接口实现类
 *
 * @author lizy
 * 2016年12月10日
 */
@Service
public class RoleMenuInfoServiceImpl implements RoleMenuInfoService {

    @Resource
    private RoleMenuInfoMapper roleMenuInfoMapper;

    @Resource
    private MenuInfoMapper menuInfoMapper;

    /**
     * 生成授权树
     *
     * @param roleId
     * @return
     */
    @Override
    public String createTree(Long roleId, String path) throws Exception {
        StringBuffer html = new StringBuffer();

        //查询所有菜单
        List<MenuInfo> list = menuInfoMapper.findMenuInfoByParams(null);

        //生成一级
        if (list != null && list.size() > 0) {
            boolean hasChildren = false;
            for (int i = 0; i < list.size(); i++) {
                MenuInfo menuInfo = list.get(i);

                Long menuId = menuInfo.getId();
                if (menuInfo.getLevel() == 1) {
                    hasChildren = false;
                    html.append("<tr treeItemLevel='1'>");
                    html.append("<td><input " + (haveRoleFunc(roleId, menuId) ? "checked" : "") + " onclick='treeIdCheck(\"m" + menuId + "\")' type='checkbox' name='ids' value='" + menuId + "' id='m" + menuId + "'/></td>");
                    html.append("<td>");

                    if (haveSon(menuId)) {
                        hasChildren = true;
                        html.append("<img align='absmiddle' style='cursor:pointer' onClick='displayChildren(this);' isAjax='false' isOpen='true' id='" + menuId + "' src='" + path + "/components/bootstrap/tree/image/minus.gif' />");
                    } else {
                        html.append("<img align='absmiddle' src='" + path + "/components/bootstrap/tree/image/empty.gif' />");
                    }

                    html.append(menuInfo.getMenuName());
                    html.append("</td></tr>");
                    if (hasChildren) {
                        List<MenuInfo> list1 = menuInfoMapper.findMenuInfoSon(menuId);
                        //处理子级
                        createTreeSon(path, list1, menuId, roleId, html, 2, menuId + "");
                    }
                }
            }
        }

        return html.toString();
    }

    /**
     * 生成授权树子菜单
     *
     * @param path
     * @return
     */
    public String createTreeSon(String path, List<MenuInfo> list1, Long pid, Long roleId, StringBuffer html, int treeItemLevel, String pidpath) throws Exception {
        //生成子级


        if (list1 != null && list1.size() > 0) {
            boolean hasChildren = false;
            for (int i = 0; i < list1.size(); i++) {
                MenuInfo menuInfo = list1.get(i);

                Long menuId = menuInfo.getId();

                if (pid.equals(Long.parseLong(menuInfo.getParentId()))) {
                    hasChildren = false;
                    html.append("<tr treeItemLevel='" + treeItemLevel + "'>");
                    html.append("<td><input " + (haveRoleFunc(roleId, menuId) ? "checked" : "") + " onclick='treeIdCheck(\"m" + pidpath + "_" + menuId + "\")'  type='checkbox' name='ids' value='" + menuId + "' id='m" + pidpath + "_" + menuId + "'/></td>");
                    html.append("<td>");
                    for (int j = 1; j < treeItemLevel; j++) {
                        html.append("<img align='absmiddle' src='" + path + "/components/bootstrap/tree/image/empty.gif' />");
                    }
                    if (haveSon(list1.get(i).getId())) {
                        hasChildren = true;
                        html.append("<img align='absmiddle' style='cursor:pointer' onClick='displayChildren(this);' isAjax='false' isOpen='true' id='" + menuId + "' src='" + path + "/components/bootstrap/tree/image/minus.gif' />");
                    } else {
                        html.append("<img align='absmiddle' src='" + path + "/components/bootstrap/tree/image/empty.gif' />");
                    }

                    html.append(menuInfo.getMenuName());
                    html.append("</td></tr>");
                    if (hasChildren) {
                        //处理子级
                        createTreeSon(path, list1, menuId, roleId, html, treeItemLevel + 1, pidpath + "_" + menuId);
                    }
                }

            }
        }

        return html.toString();
    }

    /**
     * 根据角色ID和菜单ID查询中间表信息
     */
    private boolean haveRoleFunc(Long roleId, Long menuId) throws Exception {

        int count = roleMenuInfoMapper.findRoleMenuInfoByRoleIdAndMenuId(roleId, menuId);

        if (count > 0) {
            return true;
        }

        return false;
    }

    /**
     * 根据父级菜单ID查询二级菜单ID
     *
     * @param menuId 父级菜单ID
     * @return
     * @throws Exception
     */
    private boolean haveSon(Long menuId) throws Exception {
        int count = menuInfoMapper.findMenuInfoByParentId(menuId);

        if (count > 0) {
            return true;
        }

        return false;
    }

    /**
     * 为角色绑定权限
     */
    @Override
    @Transactional
    public void addRoleMenu(Long roleId, Long[] menuIds) throws Exception {
        //删除这个角色分配的权限
        roleMenuInfoMapper.delRoleMenuByRoleId(roleId);

        if (menuIds.length > 0) {
            RoleMenuInfo roleMenuInfo = null;
            for (int i = 0; i < menuIds.length; i++) {
                Long menuId = menuIds[i];

                roleMenuInfo = new RoleMenuInfo();
                roleMenuInfo.setRoleId(roleId);
                roleMenuInfo.setMenuId(menuId);

                roleMenuInfoMapper.addRoleMenu(roleMenuInfo);
            }
        }
    }

}

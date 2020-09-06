package com.example.springboottest.service.impl;

import com.example.springboottest.bean.model.MenuInfo;
import com.example.springboottest.dao.MenuInfoMapper;
import com.example.springboottest.dao.RoleMenuInfoMapper;
import com.example.springboottest.service.MenuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 菜单权限信息service层接口实现类
 *
 * @author lizy
 * 2016年12月4日
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Resource
    private MenuInfoMapper menuInfoMapper;

    @Resource
    private RoleMenuInfoMapper roleMenuInfoMapper;

    /**
     * 根据条件获取全部菜单权限
     */
    @Override
    public List<MenuInfo> findMenuInfoByParams(Map<String, Object> params) throws Exception {
        return menuInfoMapper.findMenuInfoByParams(params);
    }

    /**
     * 获取所有父级节点的菜单
     */
    @Override
    public List<MenuInfo> findMenuInfoParent() throws Exception {
        return menuInfoMapper.findMenuInfoParent();
    }

    /**
     * 添加菜单信息
     */
    @Override
    public void addMenuInfo(MenuInfo menuInfo) throws Exception {
        menuInfoMapper.add(menuInfo);
    }

    /**
     * 修改菜单信息
     */
    @Override
    public void updateMenuInfo(MenuInfo menuInfo) throws Exception {
        menuInfoMapper.update(menuInfo);
    }

    /**
     * 批量删除菜单信息
     */
    @Override
    public void delMenuInfo(String[] ids) throws Exception {
        menuInfoMapper.del(ids);
    }

    /**
     * 根据角色查询封装菜单
     */
    @Override
    public String getMenu(Long roleId) throws Exception {

        List<MenuInfo> menuInfoList = menuInfoMapper.findMenuInfoByRoleId(roleId);


        return createMenuTree(menuInfoList);
    }

    /**
     * 创建菜单树
     *
     * @param menuInfoList
     * @return
     */
    private String createMenuTree(List<MenuInfo> menuInfoList) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < menuInfoList.size(); i++) {
            MenuInfo menuInfo = menuInfoList.get(i);

            String menuTitle = menuInfo.getMenuName();
            String menuIcon = menuInfo.getMenuIcon();
            String url = menuInfo.getUrl();

            if (menuInfo.getLevel() == 1) {
                if (i != 0) {
                    sb.append("</ul>");
                    sb.append("</li>");
                }

                sb.append("<li id=" + menuInfo.getDisplayOrder() + ">");
                sb.append("<a href=\"#\" class=\"dropdown-toggle\"><i class=\"menu-icon fa " + menuIcon + "\"></i><span class=\"menu-text\"> " + menuTitle + " </span><b class=\"arrow fa fa-angle-down\"></b></a><b class=\"arrow\"></b>");
                sb.append("<ul class=\"submenu\">");
            } else {
                sb.append("<li id=" + menuInfo.getDisplayOrder() + ">");
                sb.append("<a href=\"javascript:;\" onclick=\"contentFrame('" + url + "','" + menuTitle + "',this)\">");
                sb.append("<i class=\"menu-icon fa fa-caret-right\"></i>" + menuTitle);
                sb.append("</a><b class=\"arrow\"></b>");
                sb.append("</li>");

            }


        }

        return sb.toString();
    }

}

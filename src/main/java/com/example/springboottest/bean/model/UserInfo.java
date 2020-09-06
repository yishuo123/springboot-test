package com.example.springboottest.bean.model;


import com.example.springboottest.core.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息Model
 *
 * @author lizy
 * 2016年11月27日
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer STATUS_1 = 1;        //启用
    public static final Integer STATUS_2 = 2;        //禁用

    private Long id;            //会员ID Long

    private String userName;    //会员登录名

    private String password;    //会员密码

    private String phone;        //会员手机号

    private String realName;    //会员真实姓名

    private Long roleId;        //会员角色ID

    private Integer status;        //会员状态 做逻辑删除，1：正常 0：删除

    private String createBy;    //创建人

    private Date createDate;    //创建日期

    private String modifyBy;    //修改人

    private Date modifyDate;    //修改日期

    private String remark;        //备注

    private String roleName;     //角色名称


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {

        return roleName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", remark='" + remark + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    /**
     * 格式化创建时间
     *
     * @return
     */
    public String getCreateDateFmt() {

        if (this.createDate != null) {
            return DateUtil.sdfDateTime2(this.createDate);
        }
        return "";
    }

    /**
     * 会员角色名称
     * @return
     */
	/*public String getTypeFmt(){

		switch (roleId) {
			case 1L: return "超级管理员";
			case 2L: return "管理员";
			case 3L: return "代理管理员";
			case 4L: return "二级代理";
			case 5L: return "测试会员";
			default: return "";
		}
	}*/

    /**
     * 格式化修改时间
     *
     * @return
     */
    public String getModifyDateFmt() {

        if (this.modifyDate != null) {
            return DateUtil.sdfDateTime2(this.modifyDate);
        }
        return "";
    }

}

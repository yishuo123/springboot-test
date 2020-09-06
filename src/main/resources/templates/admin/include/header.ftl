<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>GXEVER-发票管理系统</title>
    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <#include "base_head.ftl">
    <style type="text/css">
        #sidebar-shortcuts-large .btn {
            height: 32px;
        }

        .dropdown-toggle {
            font-weight: bold;
        }

    </style>
</head>
<body class="no-skin">

<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <!-- #section:basics/sidebar.mobile.toggle -->
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="sr-only">Toggle sidebar</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- /section:basics/sidebar.mobile.toggle -->
        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-desktop"></i> GXEVER-发票管理系统
                </small>
            </a>
        </div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${images }/user_default.png" alt="Jason's Photo"/>
                        <span class="user-info">
	                                <small>Welcome,</small>
                        ${Session.userInfo.userName }
	                            </span>
                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a id="personalInfo" href="javascript:;">
                                <i class="ace-icon fa fa-user"></i>个人信息
                            </a>
                        </li>
                        <li>
                            <a id="password-index" href="javascript:;">
                                <i class="ace-icon fa fa-cog"></i>修改密码
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a id="logout" href="${path }/login/out">
                                <i class="ace-icon fa fa-power-off"></i>退出
                            </a>
                        </li>
                    </ul>
                </li><!-- /section:basics/navbar.user_menu -->
            </ul>
        </div>
    </div><!-- /.navbar-container -->
</div>
<!-- 个人信息 -->
<div id="dialog-userInfo" class="hide">
    <div class="alert alert-info bigger-110">
        <form id="userInfo-form" class="form-horizontal" role="form" method="post"
              action="${path }/admin/userInfo/updateRealName">
            <!-- #section:elements.form -->
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-userName"> 登录账户 </label>

                <div class="col-sm-9">
                    <input type="text" id="form-user-name" name="userName" value="${Session.userInfo.userName }"
                           class="col-xs-10 col-sm-8" disabled="disabled"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-phone"> 移动电话 </label>

                <div class="col-sm-9">
                    <input type="text" id="form-phone" name="phone" value="${userInfo.phone }"
                           class="col-xs-10 col-sm-8" disabled="disabled"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-real-name"> 真实姓名 </label>

                <div class="col-sm-9">
                    <input type="text" id="form-real-name" name="realName" value="${userInfo.realName }"
                           placeholder="真实姓名" class="col-xs-10 col-sm-8"/>
                </div>
            </div>

        </form>
    </div>
</div><!-- #dialog-userInfo -->

<!-- 修改密码 -->
<div id="dialog-password" class="hide">
    <div class="alert alert-info bigger-110">
        <form id="password-form" class="form-horizontal" role="form" method="post"
              action="${path }/admin/userInfo/updatePwd">
            <!-- #section:elements.form -->
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-userName"> 旧密码 </label>

                <div class="col-sm-9">
                    <input type="password" id="form-lpwd-input" name="lpwd" class="col-xs-8 col-sm-6"
                           placeholder="输入旧密码"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-phone"> 新密码 </label>

                <div class="col-sm-9">
                    <input type="password" id="form-xpwd-input" name="xpwd" class="col-xs-8 col-sm-6"
                           placeholder="输入新密码"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-zpwd-input"> 确认密码 </label>

                <div class="col-sm-9">
                    <input type="password" id="form-zpwd-input" name="zpwd" class="col-xs-8 col-sm-6"
                           placeholder="再次确认密码"/>
                </div>
            </div>
        </form>
    </div>
</div><!-- #dialog-userInfo -->

<script type="text/javascript">
    path = '${path}';

    /* $(function(){

         initGridTable();

         $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
     });*/
</script>
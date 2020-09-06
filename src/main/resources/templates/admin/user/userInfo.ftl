<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ERP服务管理系统</title>
    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <#include "../include/base_head.ftl">
    <style type="text/css">
        body {
            background-color: #f2f2f2;
        }

        .ui-th-ltr .ui-jqgrid-sortable {
            text-align: center;
        }
    </style>
</head>
<body class="common-body">

<link rel="stylesheet" href="${css }/userInfo.css"/>

<div id="grid-row" class="row">
    <div class="col-xs-12">
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="widget-box">
                <div class="widget-header">
                    <i class="ace-icon glyphicon glyphicon-search"></i>&nbsp;&nbsp;

                    <div class="widget-title">用户管理</div>

                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse"> <i
                                    class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main">
                        <div class="form-panl">
                            <label for="search-userName">用户账户:
                                <input id="search-userName" type="text" class="form-control" style="width: 150px;"
                                       placeholder="请输入用户账户"/>
                            </label>
                            <label fol="search-phone">手机号码:
                                <input id="search-phone" type="text" class="form-control" style="width: 150px;"
                                       placeholder="请输入手机号码"/>
                            </label>
                            <label for="status-select">状态:
                                <select class="form-control" id="status-select" style="width: 100px;">
                                    <option value="all">全部</option>
                                    <option value="1">正常</option>
                                    <option value="2">禁用</option>
                                </select>
                            </label>
                            <button id="search_btn" class="btn btn-info common-btn">
                                <i class="ace-icon glyphicon glyphicon-search"></i>&nbsp;搜&nbsp;索
                            </button>&nbsp;&nbsp;
                            <button id="add_btn" class="btn btn-success common-btn">
                                <i class="ace-icon glyphicon glyphicon-plus"></i>&nbsp;添&nbsp;加
                            </button>&nbsp;&nbsp;
                            <button id="edit_btn" class="btn btn-primary common-btn">
                                <i class="ace-icon fa fa-pencil-square-o"></i>&nbsp;编&nbsp;辑
                            </button>&nbsp;&nbsp;
                            <button id="forden_btn" class="btn btn-danger common-btn">
                                <i class="ace-icon fa fa-lock"></i>&nbsp;禁&nbsp;用
                            </button>&nbsp;&nbsp;
                            <button id="open_btn" class="btn btn-warning common-btn">
                                <i class="ace-icon fa fa-key"></i>&nbsp;解&nbsp;锁
                            </button>&nbsp;&nbsp;
                            <button id="del_btn" class="btn btn-danger common-btn">
                                <i class="ace-icon fa fa-trash-o"></i>&nbsp;删&nbsp;除
                            </button>&nbsp;&nbsp;
                            <button id="res_btn" class="btn btn-inverse common-btn">
                                <i class="ace-icon fa fa-refresh "></i>重置密码
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="grid-pager"></div>
        <table id="grid-table"></table>

    </div>
    <!-- /.col -->
    <#--<form id="addPage_form" action="${path }/admin/userInfo/addPage"></form>-->
    <div id="dialog-form" class="hide" disabled="disabled">
        <div class="row alert alert-info bigger-110">
            <div id="error-msg" class="alert alert-danger hide">
                <i id="error-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>
                <span id="error-msg-text"></span>
                <br/>
            </div>
            <form id="userinfo-form" class="form-horizontal" action="${path }/admin/userInfo/add" method="post">
                <#--<input type="reset" style="display:none;" />-->
                <input name="inp" id="inp" value="1" style="display:none;"/>
                <input type="hidden" name="id" id="id-input"/>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="userName-input">用户账户:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="userName" id="userName-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="phone-input">手机号码:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="phone" id="phone-input" class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="realName-input">真实姓名:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="realName" id="realName-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="role-select">用户角色:

                    </label>
                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <#--<input type="text" name="roleId" id="roleId-input" class="col-xs-12 col-sm-6 info-form"/>-->
                            <select class="form-control" id="role-select" name="roleId" style="width: 100px;">
                                <option value="all">全部</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="remark-input">备注:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <textarea type="text" name="remark" id="remark-input"
                                      class="col-xs-12 col-sm-6 info-form"></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<#include "../include/base_foot.ftl" >
<!-- 用cdn js文件导致分页栏 下一页无法显示 -->
<script src="${components}/jqGrid/js/jquery.jqGrid.min.js"></script>
<script src="${components}/jqGrid/js/grid.locale-cn.js"></script>

<script src="http://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.form/3.51/jquery.form.min.js"></script>
<!-- <script src="http://cdn.bootcss.com/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script> -->
<!-- @TODO使用cdn文件后 无法中文化 -->
<script src="${js }/common.js?ver=1"></script>
<script src="${js}/user/userInfo.js?ver=1"></script>

<script type="text/javascript">
    path = '${path}';

    $(function () {

        initGridTable();

        $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    });
</script>
</body>
</html>
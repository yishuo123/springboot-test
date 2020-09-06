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

<style type="text/css">
    .ui-th-ltr .ui-jqgrid-sortable {
        text-align: center;
    }

    #dialog-confirm .alert #export-form .confirm-text .dropdown .dropdown-menu {
        z-index: 99999;
    }

    #dialog-confirm .alert #export-form .confirm-text .dropdown .dropdown-menu li {
        background-color: #F1F1F1;
        height: 20px;
        padding-top: 0px;
    }

    #dialog-confirm .alert #export-form .confirm-text .dropdown .dropdown-menu li a {
        padding-top: 0px;
        padding-left: 10px;
    }

    #dialog-confirm .alert #export-form .confirm-text .dropdown .dropdown-menu li img {
        width: 16px;
        height: 16px;
    }
</style>
<div id="grid-row" class="row">
    <div class="col-xs-12">
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="widget-box">
                <div class="widget-header">
                    <i class="ace-icon glyphicon glyphicon-search"></i>&nbsp;&nbsp;

                    <div class="widget-title">权限管理</div>

                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse"> <i
                                    class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main">
                        <div class="form-panl">
                            <label for="search-menuName">菜单名称:
                                <input id="search-menuName" type="text" class="form-control" placeholder="请输入菜单名称"/>
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
                            <button id="del_btn" class="btn btn-danger common-btn">
                                <i class="ace-icon fa fa-trash-o"></i>&nbsp;删&nbsp;除
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

    <div id="dialog-form" class="hide">
        <div class="row alert alert-info bigger-110">
            <div id="error-msg" class="alert alert-danger hide">
                <i id="error-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>
                <span id="error-msg-text"></span>
                <br/>
            </div>
            <form id="menuInfo-form" class="form-horizontal" action="${path }/admin/menuInfo/add" method="post">
                <input type="hidden" name="id" id="id-input"/>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="menuName-input">菜单名称:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="menuName" id="menuName-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div id="menuIcon-div" class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="menuIcon-input">菜单图标:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="menuIcon" id="menuIcon-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="url-input">URL路径:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="url" id="url-input" class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right"
                           for="menuLevel-select">菜单等级:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <select class="input-medium" id="level-select" name="level">
                                <option value="1">一级菜单</option>
                                <option value="2">二级菜单</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div id="menuParent-group" class="form-group hide">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right"
                           for="menuParent-select">父级菜单:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <select class="input-medium" id="parentId-select" name="parentId" disabled="disabled">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="status-select">状态:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <select class="input-medium" id="status-select" name="status">
                                <option value="1">启用</option>
                                <option value="2">禁用</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right"
                           for="displayOrder-input">显示顺序:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="displayOrder" id="displayOrder-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="remark">备注:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <textarea class="input-xlarge" cols="1.5" name="remark" id="remark-textarea"
                                      style="max-width: 180px;"></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div><!-- #dialog-form -->

</div>

<#include "../include/base_foot.ftl" >
<script src="http://cdn.bootcss.com/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
<script src="http://cdn.bootcss.com/jqgrid/4.6.0/js/i18n/grid.locale-cn.js"></script>

<script src="http://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.form/3.51/jquery.form.min.js"></script>

<script src="${js }/common.js?ver=1"></script>
<script src="${js }/user/menuInfo.js?ver=1"></script>

<script type="text/javascript">
    $(function () {

        initGridTable();

        $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    });
</script>
</body>
</html>
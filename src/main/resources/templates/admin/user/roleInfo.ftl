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
<div id="grid-row" class="row">
    <div class="col-xs-12">
        <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
            <div class="widget-box">
                <div class="widget-header">
                    <i class="ace-icon glyphicon glyphicon-search"></i>&nbsp;&nbsp;

                    <div class="widget-title">角色管理</div>

                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse"> <i
                                    class="ace-icon fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main">
                        <div class="form-panl">
                            <label for="search-userName">角色名称:
                                <input id="search-roleName" type="text" class="form-control" placeholder="请输入角色名称"/>
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
                            </button>&nbsp;&nbsp;
                            <button id="menu_btn" class="btn btn-default common-btn">
                                <i class="ace-icon fa fa-cog"></i>&nbsp;授&nbsp;权
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="grid-pager"></div>
        <table id="grid-table"></table>

    </div><!-- /.col -->

    <!-- 角色授权弹出框 -->
    <div id="dialog-accredit" class="hide">
        <div class="row bigger-110">
            <div class="widget-content nopaddinfg">
                <form id="roleMenuInfo-form" action="${path }/admin" method="post">
                    <input type="hidden" name="id" id="id-input"/>

                    <table id="roleMenuInfo-table" class="table table-bordered table-striped with-check table-hover">
                        <thead>
                        <tr>
                            <th width="5%"><input type="checkbox" id="title-table-checkbox"
                                                  name="title-table-checkbox"/></th>
                            <th width="95%">菜单名称</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                    <div id="errorDiv" class="alert alert-error hide">
                        <span id="errorInfo"></span>
                    </div>
                </form>
            </div>
        </div>
    </div><!-- #dialog-accredit -->

    <!-- 添加或者修改角色弹出框 -->
    <div id="dialog-form" class="hide">
        <div class="row alert alert-info bigger-110">
            <div id="error-msg" class="alert alert-danger hide">
                <i id="error-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>
                <span id="error-msg-text"></span>
                <br/>
            </div>
            <form id="roleInfo-form" class="form-horizontal" action="${path }/admin/roleInfo/add" method="post">
                <input type="hidden" name="id" id="eid-input"/>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="roleName-input">角色名称:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="roleName" id="roleName-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
                        </div>
                    </div>
                </div>
                <div id="roleCode-div" class="form-group">
                    <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="roleCode-input">角色编码:</label>

                    <div class="col-xs-12 col-sm-9">
                        <div class="clearfix">
                            <input type="text" name="roleCode" id="roleCode-input"
                                   class="col-xs-12 col-sm-6 info-form"/>
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

<#--<script src="${content }/jquery/jquery.uniform.js"></script>-->
<script src="${components}/bootstrap/tree/bootstraptree.js"></script>
<script src="${js }/common.js?ver=1"></script>
<script src="${js }/user/roleInfo.js?ver=1"></script>

<script type="text/javascript">

    basePath = "${path }";

    //resize on sidebar collapse/expand
    var parent_column = $(grid_selector).closest('[class*="col-"]');
    $(document).on('settings.ace.jqGrid', function (ev, event_name, collapsed) {
        if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
            $(grid_selector).jqGrid('setGridWidth', parent_column.width());
        }
    });

    $(function () {

        initGridTable();

        $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size

        $("#title-table-checkbox").click(function () {
            if ($(this).is(':checked')) {
                $("input[name=ids]:checkbox").prop("checked", true);
                return;
            } else {
                $("input[name=ids]:checkbox").prop("checked", false);
                return;
            }
        });
    });
</script>
</body>
</html>
var grid_selector = "#grid-table";	//grid
var pager_selector = "#grid-pager";	//分页栏

var url = {
    search: function () {
        return path + '/admin/roleInfo/get';
    },
    roleMenu: function () {
        return path + '/admin/roleInfo/roleMenu';
    },
    addRoleMenu: function () {
        return path + '/admin/roleInfo/addRoleMenu';
    },
    del: function () {
        return path + "/admin/roleInfo/del"
    },
    checkRoleName: function () {
        return path + "/admin/roleInfo/checkRoleName"
    }
}

$(function () {

    //点击查询按钮事件
    $("#search_btn").click(function () {
        search();
    });

    //鼠标回车事件
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            search();
        }
    }

    //添加按钮事件
    $("#add_btn").click(function () {
        addRoleInfo();
    });

    //编辑按钮事件
    $("#edit_btn").click(function () {
        editRoleInfo();
    });

    //绑定权限点击事件
    $("#menu_btn").click(function () {
        //给角色绑定权限
        addRoleMenu();
    });

    //删除按钮点击事件
    $("#del_btn").click(function () {

        delRoleInfo();

    });

});

/**
 * 删除角色信息
 */
function delRoleInfo() {
    var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
    if (rowIds == 1) {
        $.scojs_message("没有对应权限！", $.scojs_message.TYPE_ERROR);
    } else if (rowIds != null && rowIds.length > 0) {
        var ids = rowIds;

        var names = "";

        $("#msg-span").text("确定删除以下角色");
        for (var i = 0; i < ids.length; i++) {
            var rowData = jQuery(grid_selector).jqGrid('getRowData', ids[i]);

            names += "" + rowData.roleName + "<br/>";
        }

        delInfo("删除", url.del(), names, ids);
    } else {
        $.scojs_message("请选择要删除的角色！", $.scojs_message.TYPE_ERROR);
    }
}

/**
 * 添加角色信息
 */
function addRoleInfo() {
    //form表单重置
    $("#roleInfo-form")[0].reset();
    $(".has-error").removeClass("has-error");
    $("#roleInfo-form").validate().resetForm();
    $("#error-msg").addClass('hide');
    dialogeForm("添加角色");
}

/**
 * 编辑角色信息
 */
function editRoleInfo() {

    //form表单重置
    $("#roleInfo-form")[0].reset();
    $(".has-error").removeClass("has-error");
    $("#roleInfo-form").validate().resetForm();
    $("#error-msg").addClass('hide');
    var rowId = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
    if (rowId == 1) {
        $.scojs_message("没有对应权限！", $.scojs_message.TYPE_ERROR);
    } else if (rowId != null && rowId.length == 1) {
        var rowData = $(grid_selector).jqGrid('getRowData', rowId);

        $("#eid-input").val(rowData.id);
        $("#roleName-input").val(rowData.roleName);
        $("#roleCode-input").val(rowData.roleCode);

        dialogeForm("编辑角色");
    } else {
        $.scojs_message("请选择一个要修改的角色！", $.scojs_message.TYPE_ERROR);
    }
}


/**
 * form表单dialog窗口
 */
function dialogeForm(title) {
    $("#dialog-form").removeClass('hide').dialog({
        resizable: false,
        modal: true,
        width: 560,
        title: title,
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp;保存",
                "class": "btn btn-success btn-xs",
                click: function () {
                    //校验form表单
                    if (!$('#roleInfo-form').valid()) {
                        return false;
                    } else {
                        $("#roleInfo-form").ajaxSubmit(function (data) {
                            data = eval(data);
                            if (data.state == 1) {
                                $("#dialog-form").dialog("close");
                                search();

                            } else {
                                $("#error-msg-text").text(data.message);
                                $("#error-msg").removeClass('hide');
                            }
                        });
                    }
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; 取消",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });
}

/**
 * 搜索
 */
function search() {
    jQuery(grid_selector).setGridParam({postData: getQueryParam()}).trigger("reloadGrid");
}

/**
 * 给角色添加权限
 */
function addRoleMenu() {
    var rowId = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');

    if (rowId == 1) {
        $.scojs_message("没有对应权限！", $.scojs_message.TYPE_ERROR);
    } else if (rowId != null && rowId.length == 1) {
        var row = $(grid_selector).jqGrid('getRowData', rowId);

        dialogConfirm(row.id, row.roleName);

    } else {
        $.scojs_message("请选择一个角色！", $.scojs_message.TYPE_ERROR);
    }
}

/**
 * 获取角色信息，填充角色下拉框
 */
function addRoleInfoSelect() {
    $.ajax({
        url: url.getRoleInfo(),
        dataType: 'json',
        success: function (data) {
            data = eval(data);

            if (data.length > 0) {
                var roleSelect = $("#role-select");
                roleSelect.empty();		//清空上次请求
                roleSelect.append('<option value="0">全部</option>');

                var option = '';
                for (var i = 0; i < data.length; i++) {
                    var roleInfo = data[i];

                    option = '<option value="' + roleInfo.roleCode + '">' + roleInfo.roleName + '</option>';

                    roleSelect.append(option);
                }
            }
        }
    });
}

/**
 * 检索表格
 */
function initGridTable() {
    var params = getQueryParam();
    jQuery(grid_selector).jqGrid({
        url: url.search(),
        mtype: "post",
        datatype: "json",
        postData: params,
        rowheight: 20,
        height: 500,
        width: 1000,
        autowidth: true,
        colNames: ['角色名称', '角色编码', ''],
        colModel: [
            {name: 'roleName', sortable: false, editable: true, editrules: {required: true}},
            {name: 'roleCode', width: 40, sortable: false, editable: true, editrules: {required: true, number: true}},
            {name: 'id', hidden: true}
        ],
        jsonReader: {
            root: "list",
        },
        multiselect: true,
        altRows: true,
        rownumbers: true,
        autowidth: true	//宽度自适应
    });

}

/**
 * 获取查询参数
 */
function getQueryParam() {
    var param = {
        'roleName': $("#search-roleName").val(),				//会员账户
    };

    return param;
}

/**
 * form表单dialog窗口
 */
function dialogConfirm(roleId, roleName) {

    //根据角色id请求菜单权限
    $.ajax({
        url: url.roleMenu(),
        data: 'roleId=' + roleId,
        dataType: "html",
        async: false,
        success: function (data) {
            $("#roleMenuInfo-table tbody").html(data);
        }
    });

    $("#dialog-accredit").removeClass('hide').dialog({
        resizable: false,
        modal: true,
        width: 460,
        height: 500,
        title: "角色授权: " + roleName,
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp;保存",
                "class": "btn btn-success btn-xs",
                click: function () {
                    var menuIds = [];
                    $("input[name='ids']:checked").each(function () {
                        menuIds.push($(this).attr("value"));
                    });

                    if (roleId && roleId != '') {
                        //关闭弹窗
                        $("#dialog-accredit").dialog("close");

                        addRoleMenuInfo(roleId, menuIds);

                    }

                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; 取消",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });
}

/**
 * ajax为角色绑定权限
 * @param roleId    角色ID
 * @param menuIds    权限ID
 */
function addRoleMenuInfo(roleId, menuIds) {
    //根据角色id请求菜单权限
    $.ajax({
        url: url.addRoleMenu(),
        type: 'POST',
        traditional: true,			//ajax 发送数组请求
        data: {'roleId': roleId, 'menuIds': menuIds},
        dataType: "JSON",
        success: function (data) {
            data = eval(data);

            if (data.state == 1) {
                $.scojs_message("保存成功！", $.scojs_message.TYPE_OK);

            } else {
                $.scojs_message(data.message, $.scojs_message.TYPE_ERROR);
            }
        },
        error: function () {
            $.scojs_message("操作失败！", $.scojs_message.TYPE_ERROR);
        }
    });

}

var icon = '<i id="phone-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>&nbsp;';

/**
 * 校验form表单
 */
$('#roleInfo-form').validate({
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    rules: {
        roleName: {
            required: true,
            maxlength: 50,
            remote: {
                url: url.checkRoleName(),
                data: {
                    id: function () {
                        return $("#id-input").val();
                    }
                }
            }

        },
        roleCode: {
            required: true
        }
    },

    messages: {
        roleName: {
            required: icon + "请输入角色名称",
            maxlength: icon + '角色名称最多30个字符',
            remote: icon + '角色名称已存在'
        },
        roleCode: {
            required: icon + "请输入角色编码"
        }

    },

    highlight: function (e) {
        $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
    },

    success: function (e) {
        $(e).closest('.form-group').removeClass('has-error');//.addClass('has-info');
        $(e).remove();
    },

    errorPlacement: function (error, element) {
        error.insertAfter(element);
    },

    submitHandler: function (form) {
    },
    invalidHandler: function (form) {
    }
});
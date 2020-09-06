var grid_selector = "#grid-table";	//grid
var pager_selector = "#grid-pager";	//分页栏

var url = {
    search: function () {
        return path + '/admin/userInfo/search';
    },
    checkUserName: function () {
        return path + '/admin/userInfo/checkUserName';
    },
    fordenUserInfoById: function () {
        return path + '/admin/userInfo/fordenUserInfoById';
    },
    openUserInfoById: function () {
        return path + '/admin/userInfo/openUserInfoById';
    },
    delUserInfo: function () {
        return path + "/admin/userInfo/delUserInfo"
    },
    resUserInfoById: function () {
        return path + "/admin/userInfo/resUserInfoById"
    },
    existPhone: function () {
        return path + "/admin/userInfo/existPhone"
    },
    getRoleInfo: function () {
        return path + "/admin/roleInfo/get"
    }
}

$(function () {

    //禁用添加按钮事件
    $("#forden_btn").click(function () {

        var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
        if (rowIds != null && rowIds.length > 0) {
            var ids = rowIds;

            var names = "";

            $("#msg-span").text("确定禁用以下用户");
            for (var i = 0; i < ids.length; i++) {
                var rowData = jQuery(grid_selector).jqGrid('getRowData', ids[i]);

                names += "" + rowData.userName + "<br/>";
            }

            delInfo("禁用", url.fordenUserInfoById(), names, ids);
        } else {
            $.scojs_message("请选择要禁用的角色！", $.scojs_message.TYPE_ERROR);
        }
    });

    //启用添加按钮事件
    $("#open_btn").click(function () {

        var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
        if (rowIds != null && rowIds.length > 0) {
            var ids = rowIds;

            var names = "";

            $("#msg-span").text("确定启用以下用户");
            for (var i = 0; i < ids.length; i++) {
                var rowData = jQuery(grid_selector).jqGrid('getRowData', ids[i]);

                names += "" + rowData.userName + "<br/>";
            }

            delInfo("启用", url.openUserInfoById(), names, ids);
        } else {
            $.scojs_message("请选择一个角色！", $.scojs_message.TYPE_ERROR);
        }
    });
    //点击查询按钮事件
    $("#search_btn").click(function () {
        search();
    });

    //删除按钮点击事件
    $("#del_btn").click(function () {

        delUserInfo();

    });

    //鼠标回车事件
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            search();
        }
    }

    //点击添加按钮事件
    $("#add_btn").click(function () {


        addRoleInfoSelect();
        saveUserInfo("添加用户");
    });

    //编辑添加按钮事件
    $("#edit_btn").click(function () {

        var rowId = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');

        if (rowId != null && rowId.length == 1) {
            var rowData = $(grid_selector).jqGrid('getRowData', rowId);

            saveUserInfo("编辑用户");
            var editRoleName = rowData.roleName;

            $("#id-input").val(rowData.id);
            $("#userName-input").val(rowData.userName);
            $("#phone-input").val(rowData.phone);
            $("#realName-input").val(rowData.realName);
            editRoleInfoSelect(editRoleName);
            /*$("#roleId-input").val(rowData.roleName);*/
            $("#remark-input").val(rowData.remark);

        } else {
            $.scojs_message("请选择一个要修改的用户！", $.scojs_message.TYPE_ERROR);
        }

    });

    //重置密码添加按钮事件
    $("#res_btn").click(function () {

        var rowId = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
        if (rowId != null) {
            var row = $(grid_selector).jqGrid('getRowData', rowId);

            resUserInfoById(row.id);

        } else {
            $.scojs_message("请选择一个角色！", $.scojs_message.TYPE_ERROR);
        }
    });


});


/**
 * 重置用户密码点击事件方法
 */
function resUserInfoById(rowid) {

    $.ajax({
        url: url.resUserInfoById(),
        datatype: "json",
        data: 'rowid=' + rowid,
        success: function (data) {
            if (data.state == 1) {
                $.scojs_message("操作成功！", $.scojs_message.TYPE_OK);
                search();

            } else {
                $.scojs_message(data.message, $.scojs_message.TYPE_ERROR);
            }
        },
        error: function () {
            $.scojs_message("操作失败！", $.scojs_message.TYPE_ERROR);
        }
    });
}

/**
 * 删除角色信息
 */
function delUserInfo() {
    var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');

    if (rowIds != null && rowIds.length > 0) {
        var ids = rowIds;

        var names = "";

        $("#msg-span").text("确定删除以下用户");
        for (var i = 0; i < ids.length; i++) {
            var rowData = jQuery(grid_selector).jqGrid('getRowData', ids[i]);

            names += "" + rowData.userName + "<br/>";
        }

        delInfo("删除", url.delUserInfo(), names, ids);
    } else {
        $.scojs_message("请选择要删除的角色！", $.scojs_message.TYPE_ERROR);
    }
}

/**
 * 添加和编辑事件执行方法
 * @param title
 */
function saveUserInfo(title) {
    //1.手动重置inp
    $("#inp").val('');
    //2.手动重置id
    $("#id-input").val('');

    //form表单重置
    $("#userinfo-form")[0].reset();
    $(".has-error").removeClass("has-error");
    $("#userinfo-form").validate().resetForm();
    $("#error-msg").addClass('hide');

    var html = $("#dialog-form").html();
    dialogForm(620, 430, title, "userinfo-form", html);/*560 400*/
}

/**
 * 搜索
 */
function search() {
    jQuery(grid_selector).setGridParam({postData: getQueryParam()}).trigger("reloadGrid");
}

/**
 * 初始化下拉框
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

                var option = '';
                for (var i = 0; i < data.length; i++) {
                    var roleInfo = data[i];
                    var roleId = roleInfo.id;
                    var roleName = roleInfo.roleName;

                    if (roleName == "普通用户") {
                        option = '<option value="' + roleId + '" selected>' + roleName + '</option>';
                    } else {
                        option = '<option value="' + roleId + '" >' + roleName + '</option>';
                    }

                    roleSelect.append(option);
                }
            }
        }
    });
}

/**
 * 初始化编辑下拉框
 */
function editRoleInfoSelect(editRoleName) {

    $.ajax({
        url: url.getRoleInfo(),
        dataType: 'json',
        success: function (data) {
            data = eval(data);

            if (data.length > 0) {
                var roleSelect = $("#role-select");
                roleSelect.empty();		//清空上次请求

                var option = '';
                for (var i = 0; i < data.length; i++) {
                    var roleInfo = data[i];
                    var roleId = roleInfo.id;
                    var roleName = roleInfo.roleName;
                    if (roleName == editRoleName) {
                        option = '<option value="' + roleId + '" selected>' + roleName + '</option>';
                    } else {
                        option = '<option value="' + roleId + '" >' + roleName + '</option>';
                    }

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
        height: 450,
        colNames: ['用户账户', '手机号码', '用户姓名', '用户角色', '用户状态', '创建人', '创建时间', '修改人', '修改时间', '备注', ''],
        colModel: [
            {name: 'userName', sortable: false},
            {name: 'phone', align: 'center', width: 140, sortable: false},
            {name: 'realName', align: 'center', width: 100, sortable: false},
            {name: 'roleName', width: 80, sortable: false},
            {name: 'status', width: 80, sortable: false, formatter: formatStatus},
            {name: 'createBy', width: 80, sortable: false},
            {name: 'createDateFmt', align: 'center'},
            {name: 'modifyBy', width: 80, align: 'center'},
            {name: 'modifyDateFmt', align: 'center'},
            {name: 'remark', align: 'center'},
            {name: 'id', hidden: true, key: true}
        ],
        jsonReader: {
            root: "list",
            page: "pageIndex",
            total: "totalPage",		//总页数
            records: "totalResult"		//总条数
        },
        multiselect: true,
        viewrecords: true,		//定义是否要显示总记录数
        rowNum: 10,		        //显示记录条数
        rowList: [10, 20, 50, 100],
        pager: pager_selector,
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
        'userName': $("#search-userName").val(),				//会员账户
        'phone': $("#search-phone").val(),                       //手机号码
        'status': $("#status-select").val()                      //用户状态
    };

    return param;
}


/**
 * 格式化状态
 */
function formatStatus(cellvalue, options, rowObject) {
    var status = rowObject.status;

    if (status == 1) {
        return "正常"
    } else {
        return "禁用";
    }
}

/**
 * 会员基本信息form表单验证
 */


//检测用户姓名是否为汉字
jQuery.validator.addMethod('<span style="color:#FF0000;"><strong>isChar</strong></span>', function (value, element) {
    var length = value.length;
    var regName = /[^\u4e00-\u9fa5]/g;
    return this.optional(element) || !regName.test(value);
}, icon + "请输入姓名(暂支持汉字)");

jQuery.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    var regPhone = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
    return this.optional(element) || (length == 11 && regPhone.test(value));
}, icon + "请正确填写手机号码");

/**
 * 校验form表单
 */

$('#userinfo-form').validate({

    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    rules: {
        userName: {
            required: true,
            maxlength: 30,
            remote: {
                url: url.checkUserName(),
                data: {
                    id: function () {
                        return $("#id-input").val();
                    }
                }
            }
        },
        remark: {
            maxlength: 50
        },

        realName: {
            required: true,
            '<span style="color:#FF0000;"><strong>isChar</strong></span>': true,
        },
        phone: {
            required: true,
            digits: true,
            minlength: 11,
            maxlength: 11,
            isMobile: {    //验证手机
                isMobile: true
            },
            remote: {
                url: url.existPhone(),
                data: {
                    id: function () {
                        return $("#id-input").val();
                    }
                }
            }
        }
    },

    messages: {
        userName: {
            required: icon + "请输入用户账户",
            maxlength: icon + '字符长度在12-30之间',
            remote: icon + '用户账户名已存在'
        },
        realName: {
            required: icon + "请输入真实姓名",
        },
        phone: {
            required: icon + "请输入手机号码",
            remote: icon + '手机号码已存在',
            digits: icon + '手机号码必须是数字',
            minlength: icon + '请输入正确的手机号码',
            maxlength: icon + '请输入正确的手机号码'
        },
        remark: {
            maxlength: icon + '备注最多50个字符',

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
    },
});
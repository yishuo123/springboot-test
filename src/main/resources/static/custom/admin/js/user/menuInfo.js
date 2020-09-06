var grid_selector = "#grid-table";	//grid
var pager_selector = "#grid-pager";	//分页栏

var url = {
    search: function () {
        return path + '/admin/menuInfo/find';
    },
    findParent: function () {
        return path + '/admin/menuInfo/findParent';
    },
    del: function () {
        return path + "/admin/menuInfo/del"
    }
}

$(function () {

    //查询按钮点击事件
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

    //添加按钮点击事件
    $("#add_btn").click(function () {
        addMenuInfo();
    });

    //修改按钮点击事件
    $("#edit_btn").click(function () {
        editMenuInfo();
    });

    //删除按钮点击事件
    $("#del_btn").click(function () {
        delMenuInfo();

    });

    //菜单等级下拉框事件
    $("#level-select").change(function () {
        var value = $(this).val();

        if (value == 2) {		//显示一级节点下拉框

            $("#menuParent-group").removeClass('hide');				//显示父级菜单下拉框div
            $("#parentId-select").attr("disabled", false);			//父级菜单下拉框设置可用

//			$("#menuIcon-div").addClass('hide');					//隐藏菜单图标
//			$("#menuIcon-input").attr("disabled", "disabled");		//菜单图标输入框设置可用
        } else {
            $("#menuParent-group").addClass('hide');
            $("#parentId-select").attr("disabled", "disabled");		//父级菜单下拉框设置不可用

//			$("#menuIcon-div").removeClass('hide');					//显示菜单图标
//			$("#menuIcon-input").attr("disabled", false);			//菜单图标输入框设置不可用

        }
    });

});

/**
 * 删除菜单信息
 */
function delMenuInfo() {
    var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');

    if (rowIds != null && rowIds.length > 0) {
        var ids = rowIds;

        var names = "";

        $("#msg-span").text("确定删除以下菜单");
        for (var i = 0; i < ids.length; i++) {
            var rowData = jQuery(grid_selector).jqGrid('getRowData', ids[i]);

            names += "" + rowData.menuName + "<br/>";
        }

        delInfo("删除", url.del(), names, ids);
    } else {
        $.scojs_message("请选择要删除的菜单！", $.scojs_message.TYPE_ERROR);
    }
}

/**
 * 搜索
 */
function search() {
    jQuery(grid_selector).setGridParam({postData: getQueryParam()}).trigger("reloadGrid");
}

/**
 * 添加或者编辑角色信息
 */
function addMenuInfo() {
    //form表单重置
    $("#menuInfo-form")[0].reset();

    //填充一级菜单下拉框
    getMenuInfoParent();

    dialogConfirm("添加权限");
}

/**
 * 编辑按钮事件
 */
function editMenuInfo() {
    //form表单重置
    $("#menuInfo-form")[0].reset();

    //填充一级菜单下拉框
    getMenuInfoParent();

    var rowId = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');

    if (rowId != null && rowId.length == 1) {
        var rowData = $(grid_selector).jqGrid('getRowData', rowId);

        dialogConfirm("修改权限");
        //设置父级菜单显示隐藏
        if (rowData.level == 2) {
            $("#menuParent-group").removeClass('hide');			//显示父级菜单下拉框div
            $("#parentId-select").attr("disabled", false);		//父级菜单下拉框设置可用
        } else {
            $("#menuParent-group").addClass('hide');			//隐藏父级菜单下拉框div
            $("#parentId-select").attr("disabled", "disabled");	//父级菜单下拉框设置不可用
        }

        /*rowData.status*/
        $("#id-input").val(rowData.id);
        $("#menuName-input").val(rowData.menuName);
        $("#menuIcon-input").val(rowData.menuIcon);
        $("#url-input").val(rowData.url);
        $("#level-select option[value='" + rowData.level + "']").attr("selected", "selected");
        $("#parentId-select option[value='" + rowData.parentId + "']").attr("selected", "selected");
        $("#status-select option[value='" + SelectValue(rowData.status) + "']").attr("selected", "selected");
        $("#displayOrder-input").val(rowData.displayOrder);
        $("#remark-textarea").val(rowData.remark);


    } else {
        $.scojs_message("请选择一个要修改的菜单！", $.scojs_message.TYPE_ERROR);
    }
}

/**
 * form表单dialog窗口
 */
function dialogConfirm(title) {
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
                    if (!$('#menuInfo-form').valid()) {
                        return false;
                    } else {
                        $("#menuInfo-form").ajaxSubmit(function (data) {
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
        colNames: ['菜单名称', '菜单图标', 'URL路径', '菜单等级', '父级菜单', '显示顺序', '状态', '备注', '', ''],
        colModel: [
            {name: 'menuName', align: 'center', sortable: false},
            {name: 'menuIconStr', width: 60, align: 'center', sortable: false},
            {name: 'url', sortable: false,},
            {name: 'level', width: 80, align: 'center', sortable: false},
            {name: 'parentName', align: 'center', sortable: false},
            {name: 'displayOrder', align: 'center', sortable: false},
            {name: 'status', width: 80, align: 'center', formatter: formatStatus, sortable: false},
            {name: 'remark', sortable: false},
            {name: 'id', hidden: true, key: true},
            {name: 'menuIcon', hidden: true}
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
 * 获取父级节点
 */
function getMenuInfoParent() {
    var strValue = "";

    $.ajax({
        url: url.findParent(),
        async: false,
        cache: false,		//清除缓存 防止IE不二次加载
        success: function (data) {
            if (data && data != null) {
                data = eval(data);

                var parentSelect = $("#parentId-select");
                parentSelect.empty();			//清空上次填充的下拉框内容

                var option = '';
                for (var i = 0; i < data.length; i++) {
                    var info = data[i];

                    option += '<option value="' + info.id + '">' + info.menuName + '</option>';

                }
                parentSelect.append(option);
            }

        }
    });
}

/**
 * 获取查询参数
 */
function getQueryParam() {
    var param = {
        'menuName': $("#search-menuName").val(),				//会员账户
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

var icon = '<i id="phone-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>&nbsp;';

/**
 * 通过text获取下拉框value
 * @param obj
 * @param text
 * @returns {string}
 * @constructor
 */
function SelectValue(text) {
    var val = "";
    $("#status-select option").each(function () {
        if ($(this).text() == text) {
            val = $(this).val();
            return false;
        }
    });
    return val;
}

/**
 * 校验form表单
 */
$('#menuInfo-form').validate({
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    rules: {
        menuName: {
            required: true
        },
        displayOrder: {
            required: true
        },
        remark: {
            maxlength: 50
        }
    },

    messages: {
        menuName: {
            required: icon + "请输入菜单名称"
        },
        displayOrder: {
            required: icon + "请输入显示顺序"
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
    }
});

var grid_selector = "#grid-table";	//grid
var pager_selector = "#grid-pager";	//分页栏

var url = {
    checkPwd: function(){
        return path+'/admin/userInfo/checkPwd';
    },
    login: function(){
        return path+'/login';
    },
    index: function(){
        return path+'/';
    }
}

$(function(){
	//个人信息点击事件
	$("#personalInfo").click(function(){
		dialogUserInfo();
	});

    //点击修改密码事件
    $("#password-index").click(function(){
        updatePassword();
    });
	
	$('.date-picker').datepicker({
		autoclose: true,
		todayHighlight: true
	});
	
});

/**
 * 编辑个人信息
 */
function dialogUserInfo(){
    $("#userInfo-form")[0].reset();
    $(".has-error").removeClass("has-error");
    $("#userInfo-form").validate().resetForm();
    $("#error-msg").addClass('hide');
    $("#dialog-userInfo").removeClass('hide').dialog({
        resizable: false,
        modal: true,
        width: 600,
        title: "个人信息",
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp;保存",
                "class" : "btn btn-success btn-xs",
                click: function() {
                    //TODO 个人信息密码
                    if(!$('#userInfo-form').valid()){
                        return false;
                    }else{
                        $("#userInfo-form").ajaxSubmit(function(data){
                            data = eval(data);

                            if(data.state == 1){
                                $("#dialog-userInfo").dialog( "close" );
                                $.scojs_message("修改成功！", $.scojs_message.TYPE_OK);
                                window.location.href = url.index()

                            }else{
                                $.scojs_message(data.message, $.scojs_message.TYPE_ERROR);
                            }
                        });
                    }
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; 取消",
                "class" : "btn btn-xs",
                click: function() {
                    $( this ).dialog( "close" );
                }
            }
        ]
    });
}

/**
 * 修改密码
 */
function updatePassword(){
    $("#password-form")[0].reset();
    $(".has-error").removeClass("has-error");
    $("#password-form").validate().resetForm();
    $("#error-msg").addClass('hide');
    $("#dialog-password").removeClass('hide').dialog({
        resizable: false,
        modal: true,
        width: 600,
        title: "修改密码",
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp;保存",
                "class" : "btn btn-success btn-xs",
                click: function() {
                    //TODO 修改密码
                    if(!$('#password-form').valid()){
                        return false;
                    }else{
                        $("#password-form").ajaxSubmit(function(data){
                            data = eval(data);

                            if(data.state == 1){
                                $("#dialog-password").dialog( "close" );
                                $.scojs_message("修改成功！", $.scojs_message.TYPE_OK);
                                window.location.href = url.login();

                            }else{
                                $.scojs_message(data.message, $.scojs_message.TYPE_ERROR);
                            }
                        });
                    }
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; 取消",
                "class" : "btn btn-xs",
                click: function() {
                    $( this ).dialog( "close" );
                }
            }
        ]
    });
}


var icon = '<i id="phone-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>&nbsp;';
/**
 * 校验form表单
 */
$('#password-form').validate({
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    rules: {
        lpwd: {
            required: true,
            remote : url.checkPwd(),
        },
        xpwd: {
            required: true,
            minlength: 6,
            maxlength: 20,
        },
        zpwd:{
            equalTo:"#form-xpwd-input"
        }
    },

    messages: {
        lpwd: {
            required:   icon + "请输入旧密码",
            remote :    icon + "旧密码不正确！",
        },
        xpwd: {
            required: icon+"请输入新密码",
            minlength: icon + "新密码长度不能少于6位",
            maxlength: icon + "新密码长度不能大于22位"
        },
        zpwd: {
            equalTo: icon +"两次输入的密码不一致"
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

//检测用户姓名是否为汉字
jQuery.validator.addMethod('<span style="color:#FF0000;"><strong>isChar</strong></span>', function(value, element) {
    var length = value.length;
    var regName = /[^\u4e00-\u9fa5]/g;
    return this.optional(element) || !regName.test( value );
}, icon+"请输入姓名(暂支持汉字)");
/**
 * 校验个人信息form表单
 */
$('#userInfo-form').validate({
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    rules: {
        realName: {
            required: true,
            '<span style="color:#FF0000;"><strong>isChar</strong></span>':true,
        },
    },

    messages: {
        realName: {
            required: icon+"请输入真实姓名",
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
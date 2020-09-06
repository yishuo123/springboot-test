var login = {
    url: {
        index: function () {			//检索
            return '/admin';
        }
    }
}

$(function () {

    //鼠标回车事件
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            loginSubmit();
        }
    }

    //登录按钮事件
    $("#login-btn").click(function () {
        loginSubmit();
    });
});

/**
 * 用户登录
 */
function loginSubmit() {
    if (checkNull()) {
        $("#login-form").ajaxSubmit(function (data) {
            data = eval(data);

            if (data.state == 1) {
                window.location = login.url.index();
            } else {
                $("#login-msg-text").text(data.message);
                $("#login-msg").removeClass('hide');
            }
        });
    }
}

/**
 * 校验登录名和密码输入框是否正确
 */
function checkNull() {
    var userName = "username-input", pwd = "pwd-input";

    var isUserName = isNull(userName), isPwd = isNull(pwd);
    if (!isUserName) {
        $("#login-msg").removeClass('hide');
        $("#" + userName).focus();

        return false;

    } else if (!isPwd) {

        $("#login-msg").removeClass('hide');
        $("#" + pwd).focus();

        return false;

    } else {
        $("#login-msg").addClass('hide');
    }

    return true;
}

/**
 * 校验输入框是否为空
 * @param id
 */
function isNull(id) {
    id = $("#" + id);

    if (id.val() && id.val() != '') {
        return true;
    }

    return false;
}
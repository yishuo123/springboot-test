/**
 *根据id批量删除菜单
 */
function delInfo(tn, u, names, ids){

        $("#ids-name").html(names);

        $("#dialog-confirm").removeClass('hide').dialog({
            resizable: false,
            modal: true,
            title: "确认"+tn,
            title_html: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-check'></i>&nbsp;确定&nbsp;",
                    "class" : "btn btn-success btn-xs",
                    click: function() {
                        $.ajax({
                            url: u,
                            traditional: true,			//ajax 发送数组请求
                            data: {'ids': ids },
                            dataType: 'json',
                            success: function(data){
                                data = eval(data);

                                if(data.state == 1){
                                    $.scojs_message(tn+"成功！", $.scojs_message.TYPE_OK);
                                    search();

                                }else{
                                    $.scojs_message(data.message, $.scojs_message.TYPE_ERROR);
                                }
                            },
                            error: function(){
                                $.scojs_message(tn+"失败！", $.scojs_message.TYPE_ERROR);
                            }
                        });
                        $( this ).dialog( "close" );
                    }
                }, {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp;取消&nbsp;",
                    "class" : "btn btn-xs",
                    click: function() {
                        $( this ).dialog( "close" );
                    }
                }
            ]
        });
}

/**
 * 添加或编辑弹出框
 * @param width     弹出框宽度
 * @param height    弹出框高度
 * @param title     弹出框title
 * @param formId
 * @param html
 */
function dialogForm(width, height, title, formId, html){

    $("#dialog-content").html();
    $("#dialog-content").html(html);

    $("#dialog-form").removeClass('hide').dialog({
        resizable: false,
        modal: true,
        width: width,
        height: height,
        title: title,
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp;保存",
                "class" : "btn btn-success btn-xs",
                click: function() {
                    //校验form表单
                    if(!$('#'+formId).valid()){
                        return false;
                    }else{

                        $("#"+formId).ajaxSubmit(function(data){
                            data = eval(data);

                            if(data.state == 1){
                                $("#dialog-form").dialog( "close" );
                                search();

                            }else{
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
                "class" : "btn btn-xs",
                click: function() {

                    $( this ).dialog( "close" );
                }
            }
        ]
    });
}

/**
 * 设置主页面高度
 */
function setMainHeight(height) {

    $("#contentFrame", window.top.document).css("height", height+"px");
}
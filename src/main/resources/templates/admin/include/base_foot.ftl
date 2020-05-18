<!-- 消息提示窗口 -->
<div id="dialog-message" class="hide"><p style="margin: 10px;"></p></div><!-- #dialog-message -->

<!-- 下载进度条 -->
<div id="dialog-progress" class="hide">
	<!-- #section:elements.progressbar -->
	<div class="progress" data-percent="0%" style="margin-top: 5%;">
		<div class="progress-bar" style="width:0%;"></div>
	</div>
	<div id="msg"><span></span></div>
</div><!-- #progress-message -->

<!-- #dialog-confirm 消息确认框 -->
<div id="dialog-confirm" class="hide">
    <div class="space-6"></div>
    <p class="bigger-110 bolder grey">
        <i class="ace-icon fa fa-hand-o-right blue bigger-120"></i>
        <span id="msg-span"></span>
    </p>
    <div id="ids-name" class="alert alert-info bigger-110" style="max-height: 100px; overflow:auto; padding: 10px; "></div>
</div><!-- #dialog-confirm -->

<#--<div id="dialog-form" class="hide">
    <div class="row alert alert-info bigger-110">
        <div id="error-msg" class="alert alert-danger hide" >
            <i id="error-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>
            <span id="error-msg-text"></span>
            <br/>
        </div>
		<div id="dialog-content"></div>
    </div>
</div>--><!-- #dialog-accredit &ndash;&gt;-->

<!-- jquery-ui -->
<script src="http://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>

<!-- Bootstrap -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> 

<!--if lte IE 8-->
<script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

<script src="${components}/bootstrap-ace/js/ace.min.js"></script>
<script src="${components}/bootstrap-ace/js/ace-elements.min.js"></script>

<script src="http://cdn.bootcss.com/sco.js/1.1.0/js/sco.modal.min.js"></script>
<script src="http://cdn.bootcss.com/sco.js/1.1.0/js/sco.confirm.min.js"></script>
<script src="http://cdn.bootcss.com/sco.js/1.1.0/js/sco.message.min.js"></script>

<script type="text/javascript">

	var path = '${path}';			//定义js通用根路径
    var icon = '<i id="phone-msg-icon" class="ace-icon fa fa-warning" style="width: 20px;"></i>&nbsp;';
	<!--消息提示-->
	function showDialogMessage(message, color){
		$("#dialog-message p" ).html(message);
		
		if(color == -1){
			$("#dialog-message p" ).css("color", "red");
		}else{
			$("#dialog-message p" ).css("color", "green");
		}
		
		var dialog = $("#dialog-message" ).removeClass('hide').dialog({
			modal: true,
			title: "提示",
			title_html: true,
			buttons: [ 
				{
					text: "关闭",
					"class" : "btn btn-xs",
					click: function() {
						$( this ).dialog( "close" ); 
					} 
				}
			]
		});
	}

	/**
	 * 进度条
	 */
	function showDialogProgress(){

		var dialog = $("#dialog-progress" ).removeClass('hide').dialog({
			title: '导出文件进度',
			closeOnEscape: false,
			draggable: false,
			resizable: false,
			height: 150,
			width:600,
			modal: true,
			open:function(event,ui){
				$(".ui-dialog-titlebar-close").hide();
			}
		});

		//$("#progress-message").siblings('div.ui-dialog-titlebar').remove();
	}
	
	/**
	 *关闭进度条
	 */
	function hideDialogProgress(){
		$("#dialog-progress").dialog( "close" );	//关闭进度条
	}
	
	/**
	  *设置进度
	  */
	function setProgress(realTime){
		$(".progress").attr('data-percent', realTime+'%');
		$(".progress .progress-bar").css('width', realTime+'%');
	}
	
	/**
	 *重置进度条
	 */
	function resetProgress(){
		//重置进度条
		$(".progress").attr('data-percent', '0%');
		$(".progress .progress-bar").css('width', '0%');
	}
	
	function setProgressMsg(msg){
		
	}

/*    function contentFrame(frameSrc, title, v){
        $('.breadcrumb li:eq(1)').remove();
        //$(".active").removeClass("active");			//清除所有选中样式

        $('.breadcrumb').append('<li>'+title+'</li>');

        //$(v).parent("li").addClass("active");		//添加选中样式
		var id = $(v).parent("li").attr("id")
		location.href = frameSrc+"?menuId="+ id;
    }*/
	
	function getBasePath() {
		return "http://"+document.location.host+"/";
	}
</script>

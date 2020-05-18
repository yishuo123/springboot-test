<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar responsive">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <!-- #section:basics/sidebar.layout.shortcuts -->
            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>

            <!-- /section:basics/sidebar.layout.shortcuts -->
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul id="menu-ul" class="nav nav-list"></ul> <!-- /.nav-list -->

    <!-- #section:basics/sidebar.layout.minimize -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <!-- /section:basics/sidebar.layout.minimize -->
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
        $(function(){
            $('[data-rel=tooltip]').tooltip();

            //请求菜单
            $.ajax({
                url: '${path}/admin/getMenu',
                dataType: "html",
                success: function(data){
                    $("#menu-ul").html(data);
                }
            });


        });
        function contentFrame(frameSrc, title, v){
            $('.breadcrumb li:eq(1)').remove();
            $(".active").removeClass("active");			//清除所有选中样式

            $('.breadcrumb').append('<li>'+title+'</li>');
            $('iframe').attr("src",'${path}'+frameSrc);
            $(v).parent("li").addClass("active");		//添加选中样式
        }
    </script>
    <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
</div>

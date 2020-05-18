<#assign path = request.contextPath>
<#assign components = request.contextPath+"/components">
<#assign css = request.contextPath+"/custom/admin/css">
<#assign js = request.contextPath+"/custom/admin/js">
<#assign images = request.contextPath+"/custom/admin/images">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<link rel="stylesheet" href="${components}/bootstrap-ace/css/font-awesome.min.css" />

<!-- jqGrid -->
<link href="http://cdn.bootcss.com/jqgrid/4.6.0/css/ui.jqgrid.css" rel="stylesheet"> 

<!-- ace text fonts -->
<link rel="stylesheet" href="${components}/bootstrap-ace/css/ace-fonts.css" />

<link rel="stylesheet" href="${components}/jquery/css/colorbox.min.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${components }/bootstrap-ace/css/ace.min.css" />

<!-- jquery-ui @TODO不能用cdn cdn中沒有1.10.4 css,用過后jqgrid样式改变  -->
<link rel="stylesheet" href="${components}/jquery-ui/css/jquery-ui.min.css" />

<link rel="stylesheet" href="${components}/bootstrap-ace/css/ace.part.css" />

<!--if lte IE 9-->
<link rel="stylesheet" href="${components}/bootstrap-ace/css/ace-ie.min.css" />

<#--<link rel="stylesheet" href="${components}/bootstrap-ace/css/ace-part2.min.css" />-->
<link href="http://cdn.bootcss.com/sco.js/1.1.0/css/scojs.min.css" rel="stylesheet">

<!-- common styles -->
<link rel="stylesheet" href="${css }/common.css" />

<!--if !IE -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js'>"+"<"+"/script>");
</script>

<!--if IE-->
<script type="text/javascript">
    window.jQuery || document.write("<script src='http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js'>"+"<"+"/script>");
</script>

<!--jquery form ajax-->
<script src="http://cdn.bootcss.com/jquery.form/3.51/jquery.form.min.js"></script>

<!--jquery form validate-->
<script src="http://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
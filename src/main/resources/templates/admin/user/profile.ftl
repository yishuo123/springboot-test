<#--<%@ page language="java" contentType="text/html; charset=UTF-8"-->
<#--	pageEncoding="UTF-8"%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人信息-管理后台</title>
	
	<meta name="description" content="overview &amp; stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

	<#include "../include/base_head.ftl">
	<link rel="stylesheet" href="${css }/admin/profile.css"/>
</head>
<body class="no-skin">
	<div id="user-profile-1" class="user-profile row">
		<div class="col-xs-12 col-sm-3 center">
			<div>
				<!-- #section:pages/profile.picture -->
				<span class="profile-picture"> 
					<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="${images }/admin/userinfo/profile-pic.jpg" />
				</span>

				<!-- /section:pages/profile.picture -->
				<div class="space-4"></div>

				<div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
					<div class="inline position-relative">
						<a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown"> 
							<i class="ace-icon fa fa-circle light-green"></i> &nbsp; 
							<span class="white">设置在线状态</span>
						</a>

						<ul class="align-left dropdown-menu dropdown-caret dropdown-lighter">
							<li class="dropdown-header">在线状态</li>
							<li>
								<a href="#">
									<i class="ace-icon fa fa-circle green"></i>&nbsp; 
									<span class="green">在线</span>
								</a>
							</li>
							<li>
								<a href="#"> 
									<i class="ace-icon fa fa-circle red"></i> &nbsp; 
									<span class="red">忙碌</span>
								</a>
							</li>
							<li>
								<a href="#"> 
									<i class="ace-icon fa fa-circle grey"></i>&nbsp; 
									<span class="grey">隐身</span>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="space-6"></div>

		</div>

		<div class="col-xs-12 col-sm-9">

			<!-- #section:pages/profile.info -->
			<div class="profile-user-info profile-user-info-striped">
				<div class="profile-info-row">
					<div class="profile-info-name">登录账户</div>

					<div class="profile-info-value">
						<span class="editable" id="username">${userInfo.userName }</span>
					</div>
				</div>

				<div class="profile-info-row">
					<div class="profile-info-name">地址</div>

					<div class="profile-info-value">
						<i class="fa fa-map-marker light-orange bigger-110"></i>
						<span class="editable" id="country">河南省</span> 
						<span class="editable" id="city">舞钢市</span>
					</div>
				</div>

				<div class="profile-info-row">
					<div class="profile-info-name">年龄</div>

					<div class="profile-info-value">
						<span class="editable" id="age">28</span>
					</div>
				</div>

				<div class="profile-info-row">
					<div class="profile-info-name">注册时间</div>

					<div class="profile-info-value">
						<span class="editable" id="signup">2016-11-27</span>
					</div>
				</div>

				<div class="profile-info-row">
					<div class="profile-info-name">上次登录时间</div>

					<div class="profile-info-value">
						<span class="editable" id="login">2016-11-27 13:24:56</span>
					</div>
				</div>

			</div>

		</div>
	</div>

	<%@include file="../inc/base_foot.jsp"%>

</body>
</html>
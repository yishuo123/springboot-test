<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统</title>
</head>
<body>
用户登录
<h1> 用户登录 </h1>
<#--${name}-->

<p>${msg!''}</p>
<form method="post" action="/user/loginInfo">
    用户名<input name="name" type="text" > <br/>
    密码<input name="password" type="text" > <br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
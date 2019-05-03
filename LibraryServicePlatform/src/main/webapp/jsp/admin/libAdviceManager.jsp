<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="<%=path %>/css/bootstrap.css" type="text/css" rel="stylesheet" media="screen">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">
	<style type="text/css">
		
	</style>
</head>
<body>
	<header id="top">
		<!-- 标题展示 -->
		<div id="title">
			<span>图书馆后台管理平台</span>
		</div>
		<!-- 用户名加签到展示 -->
		<div id="user">
			<span><a href="<%=path%>/jsp/admin/adminMaster.jsp">首页</a></span>
				<%--<span>用户名：</span>--%>
				<%--<span></span>--%>
				<%--<span><a>签到</a></span>--%>
		</div>
	
	</header>

	<div class="middle clear_float">
		<aside class="float_to_left">

			<div id="label">
				<label>图书馆公告管理</label>
			</div>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="addLibAdvice.jsp" target="new">添加图书馆公告</a></li>
					<!-- 没有删除图书馆公告的功能 -->
					<!-- <li><a href="deleteLibAdvice.html" target="new">删除图书馆公告</a></li> -->
					<!-- 没有修改图书馆公告的功能 -->
					<!-- <li><a href="modifyLibAdvice.html" target="new">修改图书馆公告</a></li> -->
					<li><a href="<%=path %>/libAdvice/queryLibAdvice.do" target="new">查看图书馆公告</a></li>
					<li><a href="<%=path %>/admin/adminLogout.do">退出</a></li>
				</ul>
		</aside>
		<article class="float_to_right">
			<div id="content">
				<iframe id="newWin" src="addLibAdvice.jsp" frameborder="0" name="new"></iframe>
			</div>
		</article>
	</div>
	
	<footer class="clear_float">
	</footer>
</body>
</html>
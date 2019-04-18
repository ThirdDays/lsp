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
				<span>用户名：</span>
				<span></span>
				<span><a>签到</a></span>
		</div>
	
	</header>

	<div class="middle clear_float">
		<aside class="float_to_left">

			<div id="label">
				<label>书籍资料信息管理</label>
			</div>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="addBook.jsp" target="new">添加书籍资料信息</a></li>
					<li><a href="modifyBook.jsp" target="new">修改书籍资料信息</a></li>
					<li><a href="deleteBook.jsp" target="new">删除书籍资料信息</a></li>
					<li><a href="../common/queryBook.jsp" target="new">查询书籍资料信息</a></li>
					<li><a href="<%=path %>/book/queryHotBook.do" target="new">查看热门书籍资料信息</a></li>
					<li><a href="">退出</a></li>
				</ul>
		</aside>
		<article class="float_to_right">
			<div id="content">
				<iframe id="newWin" src="addBook.jsp" frameborder="0" name="new"></iframe>
			</div>
		</article>
	</div>
	
	<footer class="clear_float">
	</footer>
</body>
</html>
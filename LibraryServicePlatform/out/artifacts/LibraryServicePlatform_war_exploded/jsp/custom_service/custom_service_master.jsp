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
			<span>前台客服</span>
		</div>
		<!-- 用户名加签到展示 -->
		<div id="user">
				<span><a href="<%=path %>/jsp/custom_service/custom_service_master.jsp">首页</a></span>
				<span>用户名：</span>
				<span></span>
				<span><a>签到</a></span>
		</div>
	
	</header>

	<div class="middle clear_float">
		<aside class="float_to_left">

			<div id="label">
				<label>导航栏</label>
			</div>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="<%=path %>/jsp/common/queryBook.jsp" target="new">书籍资料查询</a></li>
					<li><a href="<%=path %>/book/queryHotBook.do" target="new">查看热门书籍</a></li>
					<li><a href="<%=path %>/jsp/custom_service/bookBorrow_cs.jsp">办理书籍借阅</a></li>
					<!-- 查看图书馆公告的请求是要传到后台的，这里为了方便测试直接连接到目标页面 -->
					<li><a href="<%=path %>/libAdvice/queryLibAdvice.do" target="new">查看图书馆公告</a></li>
					<li><a href="">退出</a></li>
				</ul>
		</aside>
		<article class="float_to_right">
			<div id="content">
				<iframe id="newWin" src="<%=path %>/jsp/common/queryBook.jsp" frameborder="0" name="new"></iframe>
			</div>
		</article>
	</div>
	
	<footer class="clear_float">
	</footer>
</body>
</html>
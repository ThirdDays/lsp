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
		#newWin{
			width: 100%;
			height: 100%;
		}
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
				<%--<span>用户名：</span>--%>
				<%--<span></span>--%>
				<%--<span><a>签到</a></span>--%>
		</div>
	
	</header>

	<div class="middle clear_float">
		<aside class="float_to_left">

			<div id="label">
				<label>书籍借阅</label>
			</div>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="borrowBook.jsp" target="new">办理书籍借阅业务</a></li>
					<li><a href="returnBook.jsp" target="new">办理书籍归还业务</a></li>
					<!-- 该链接要连接到后台，这里暂时先连接到目标页面 -->
					<li><a href="<%= path%>/borrow/queryBorrowNotBeReturnedButOverdueRecord.do" target="new">查看书籍逾期未还</a></li>
					<li><a href="<%=path %>/teach/teachLogout.do">退出</a></li>
				</ul>
		</aside>
		<article class="float_to_right">
			<div id="content">
				<iframe id="newWin" src="borrowBook.jsp" frameborder="0" name="new"></iframe>
			</div>
		</article>
	</div>
	
	<footer class="clear_float">
	</footer>
</body>
</html>
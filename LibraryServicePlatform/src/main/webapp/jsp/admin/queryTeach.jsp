<%@ page import="com.lsp.domain.po.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Teacher teach = (Teacher) request.getAttribute("teach");
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	 <link href="<%=path %>/css/bootstrap.css" type="text/css" rel="stylesheet" media="screen">
	<title>Document</title>
	<style type="text/css">
		#query{
			width: 40%;
			margin: 20px auto;
		}
		#display{
			width: 100%;
		}
	</style>
</head>
<body>
	<!-- 查询部分 -->
				<div id="query">
					<form class="form-search" action="<%=path %>/teach/queryTeachById.do" method="post">
      					<input name="teachId" type="text" class="input-medium search-query" required="required" placeholder="请输入教师ID">
      					<button type="submit" class="btn">查询</button>
    				</form>
				</div>
				<!-- 展示部分 -->
				<div id="display">
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<th>教师ID</th>
							<th>姓名</th>
							<!-- <th>密码</th> -->
							<%--<th>余额</th>--%>
						</tr>
						<%
							if(teach!=null) {
						%>
						<td><%=teach.getTeachId() %></td>
						<td><%=teach.getTeachName() %></td>
						<%--<td><%=admin.getBalances() %></td>--%>
						<%
							}
						%>
					</table>
				</div>
</body>
</html>
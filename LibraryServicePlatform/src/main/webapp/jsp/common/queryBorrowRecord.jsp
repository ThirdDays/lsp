
<%@ page import="java.util.List" %>
<%@ page import="com.lsp.domain.po.Borrow" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
				<!-- 展示部分 -->
				<div id="display">
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<th>借阅人ID</th>
							<th>书号</th>
							<th>借阅时间</th>
							<th>期限</th>
							<th>还书时间</th>
							<th>是否已还</th>
						</tr>
						<%
							List<Borrow> list = (List<Borrow>)request.getAttribute("borrowList");
							if(list != null) {
//								System.out.println(list.size());
								for(Borrow borrow : list) {		//遍历集合

//							System.out.println(list.size());
						%>
						<tr>
							<!-- 显示数据 -->
							<td><%=borrow.getUserId() %></td>
							<td><%=borrow.getBookId() %></td>
							<td><%=borrow.getBorrowTime() %></td>
							<td><%=borrow.getTerm() %></td>
							<td><%=borrow.getReturnTime() %></td>
							<td><%=borrow.getStatus() %></td>
						</tr>
						<%
								}
							}
						%>
					</table>
				</div>
</body>
</html>
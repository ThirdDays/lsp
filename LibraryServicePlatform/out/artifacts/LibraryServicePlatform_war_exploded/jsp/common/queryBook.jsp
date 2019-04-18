<%@ page import="java.util.LinkedList" %>
<%@ page import="com.lsp.domain.po.Book" %>
<%@ page import="java.util.List" %>
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
	<!-- 查询部分 -->
				<div id="query">
					<form class="form-search" action="<%=path %>/book/queryBook.do" method="post">
      					<input name="queryCondition" type="text" class="input-medium search-query" required="required" placeholder="请输入书号,书名,分类，作者或位置查询">
      					<button type="submit" class="btn">查询</button>
    				</form>
				</div>
				<!-- 展示部分 -->
				<div id="display">
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<th>书号</th>
							<th>书名</th>
							<th>作者</th>
							<th>状态</th>
							<th>热点</th>
							<th>出版社</th>
							<th>书籍类型</th>
							<th>书籍位置</th>
						</tr>
						<%
							List<Book> list = (List<Book>)request.getAttribute("bookList");
							if(list != null) {
//								System.out.println(list.size());
								for(Book book : list) {		//遍历集合

//							System.out.println(list.size());
						%>
						<tr>
							<!-- 显示数据 -->
							<td><%=book.getBookId() %></td>
							<td><%=book.getBookName() %></td>
							<td><%=book.getAuthor() %></td>
							<td><%=book.getStatus() %></td>
							<td><%=book.getHot() %></td>
							<td><%=book.getPubCompany() %></td>
							<td><%=book.getCategory() %></td>
							<td><%=book.getLocation() %></td>
						</tr>
						<%
								}
							}
						%>
					</table>
				</div>
</body>
</html>
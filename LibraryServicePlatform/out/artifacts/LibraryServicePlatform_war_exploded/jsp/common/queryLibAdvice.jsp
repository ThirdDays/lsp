<%@ page import="com.lsp.domain.po.LibAdvice" %>
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
		#one{
			width: 20%;
			text-align: center;
		}
		#two{
			width: 80%;
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="display">
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<th id="one">发布时间</th>
				<th id="two">内容</th>
					<%
							List<LibAdvice> list = (List<LibAdvice>)request.getAttribute("libAdviceList");
							if(list != null) {
//								System.out.println(list.size());
								for(LibAdvice libAdvice : list) {		//遍历集合

//							System.out.println(list.size());
						%>
			<tr>
				<!-- 显示数据 -->
				<td><%=libAdvice.getTime() %></td>
				<td><%=libAdvice.getContent() %></td>
			</tr>
			<%
					}
				}
			%>
			</tr>
		</table>
	</div>
</body>
</html>
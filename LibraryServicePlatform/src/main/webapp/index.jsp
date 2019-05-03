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
    <!-- Bootstrap -->
    <link href="<%=path %>/css/bootstrap.css" type="text/css" rel="stylesheet" media="screen">
    <style type="text/css">
        *{
			margin: 0;
			padding: 0;
		}
		body{
			background-color: #69c0ff;
		}
		.red{
			background-color: red;
		}
		.blue{
			background-color: blue;
		}
		/*
			width和height属性设置的是元素内容的宽度和高度
			内边距和外边距的宽度不计入元素内容的宽度和高度。
			单独设置内边距时会撑大盒子，而外边距不会。
		*/
		.form{
			width: 300px;
			height: 300px;
			margin: 100px auto;
			border: solid 2px #69c0ff;
		}
		.main{
			width: 280px;
			margin: 40px auto;
			/*background-color: red;*/
		}
		.inline_to_block{
			display: block;
		}
		.center{
			margin: 50px auto;
			/*background-color: red;*/
		}
		.float_to_left{
			float: left;
		}
		.float_to_right{
			float: right;
		}
		div{
			clear: both;
		}
		label{
			float: left;
		}
		input{
			float: right;
		}
		select{
			float: right;
		}
		button{
			/*margin-top: 50px;*/
			clear: both;
		}
		.clear_float{
			clear: both;
		}
		p{
			text-align: center;
			font-size: 22px;
			margin-bottom: 30px;
		}
    </style>
    
</head>
<body>

	<div>
	<!-- <form>标签是一个块级元素 -->
		<form class="form" action="<%=path %>/login.do" method="post">
			<div class="main">
				<p>欢迎使用图书馆服务平台</p>
      			<div>
      				<label>账号：</label>
      				<input type="text" name="id" placeholder="请输入工号或学号" required="required">
      			</div>
      			<div>
					<label>密码：</label>
					<input type="password" name="password" placeholder="请输入密码" required="required">
      			</div>
      			<div>
      				<label>身份：</label>
					<select name="identifier" required="required">
						<option value="admin">管理员</option>
						<%--<option value=staff>普通职工</option>--%>
						<option value="customService">前台客服</option>
						<option value="teachr">教师</option>
						<option value="stu">学生</option>
					</select>
      			</div>
      			<button class="inline_to_block btn center" type="submit">登录</button>
      		</div>
		</form>
	</div>

</body>
</html>
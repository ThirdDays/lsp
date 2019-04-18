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
	<style type="text/css">
		#form{
			width: 80%;
			margin:0 auto;
		}
		.form{
			width: 80%;
			height: 40%;
			margin: 5% auto;
			/*border: solid 2px black;*/
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
	<div id="form">
		<form class="form" action="<%=path%>/teach/modifyTeach.do" method="post">
			<div class="main">
				<p>修改教师信息</p>
      			<div>
      				<label>ID：</label>
      				<input type="text" name="teachId" placeholder="请输入教师ID" required="required">
      			</div>
      			<div>
					<label>姓名：</label>
					<input type="text" name="teachName" placeholder="请输入教师姓名" required="required">
      			</div>
      			<div>
      				<label>密码：</label>
      				<input type="text" name="passwords" placeholder="请输入初始密码" required="required">
      			</div>
      			<div>
      				<label>余额：</label>
      				<input type="text" name="balances" placeholder="请输入初始余额" required="required">
      			</div>
      			<button class="inline_to_block btn center" type="submit">修改</button>
      		</div>
		</form>
	</div>

</body>
</html>
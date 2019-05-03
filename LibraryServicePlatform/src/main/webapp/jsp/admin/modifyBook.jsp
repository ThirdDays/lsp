<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String msg = (String)request.getAttribute("msg");
	if(msg == null) {
		msg="null";
	}
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
		<form class="form" action="<%=path%>/book/modifyBook.do" method="post">
			<div class="main">
				<p>修改书籍资料信息</p>
      			<div>
      				<label>书号：</label>
      				<input type="text" name="bookId" placeholder="请输入书号" required="required">
      			</div>
      			<div>
					<label>书名：</label>
					<input type="text" name="bookName" placeholder="请输入书名" required="required">
      			</div>
      			<div>
      				<label>作者：</label>
      				<input type="text" name="author" placeholder="请输入书作者名" required="required">
      			</div>
      			<div>
      				<label>状态：</label>
      				<input type="text" name="status" placeholder="请输入书籍的状态" required="required">
      			</div>
      			<div>
      				<label>热点：</label>
      				<input type="text" name="hot" placeholder="请输入书籍初始热点值" required="required">
      			</div>
      			<div>
      				<label>出版社</label>
      				<input type="text" name="pubCompany" placeholder="请输入书籍出版社" required="required">
      			</div>
      			<div>
      				<label>类型：</label>
      				<input type="text" name="category" placeholder="请输入书籍类型" required="required">
      			</div>
      			<div>
      				<label>位置：</label>
      				<input type="text" name="location" placeholder="请输入书籍位置" required="required">
      			</div>
      			<button class="inline_to_block btn center" type="submit">修改</button>
      		</div>
		</form>
	</div>

</body>
<script type="text/javascript">
	var messages="null";
	messages="<%=msg %>";
	// window.alert(messages);
	if(messages != "null") {
		window.alert(messages);
	}
</script>
</html>
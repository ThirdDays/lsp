<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	 <link href="../css/bootstrap.css" type="text/css" rel="stylesheet" media="screen">
	<style type="text/css">
		*{
			margin: 0;
			padding: 0;
		}
		.float_to_left{
			float: left;
		}
		.float_to_right{
			float: right;
		}
		.clear_float{
			clear: both;
		}
		.middle{
			width: 100%;
			background-color: green;
		}
		aside{
			width: 20%;
			height: 100px;
			/*background-color: red;*/
		}
		article{
			width: 80%;
			height: 100px;
			/*background-color: blue;*/
		}
		#label{
			font-size: 2em;
			color: white;
			background-color: #69c0ff;
		}
		#title{
			padding-top: 60px;
			padding-bottom: 30px;
			text-align: center;
			font-size: 3em;
		}
		#top{
			width: 100%;
			background-color: #69c0ff;
			margin-bottom: 30px; 
		}
		#user{
			width: 90%;
			text-align: right;
		}
		.red {
			background-color: red;
		}
		#content{
			width: 90%;
			height: 400px;
			margin: 0 auto;
			border: solid 2px blue;
			/*background-color: blue;*/
		}
		p{
			padding-top: 100px;
			text-align: center; 
			/*margin: auto auto;*/
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
				<span>用户名：</span>
				<span></span>
				<span><a>签到</a></span>
		</div>
	
	</header>

	<div class="middle clear_float">
		<aside class="float_to_left">

			<div id="label">
				<label>书籍资料查询</label>
			</div>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href="">按书号，书名,作者名，分类，位置查询</a></li>
					<li><a href="">按分类查询</a></li>
					<li><a href="">查看热门书籍</a></li>
					<li><a href="">按位置查询</a></li>
					<li><a href="">退出</a></li>
				</ul>
		</aside>
		<article class="float_to_right">
			<div id="content">
				<p>欢迎来到这里！请点击左边导航栏中的按钮来进行相关操作！</p>
			</div>
		</article>
	</div>
	
	<footer class="clear_float">
	</footer>
</body>
</html>
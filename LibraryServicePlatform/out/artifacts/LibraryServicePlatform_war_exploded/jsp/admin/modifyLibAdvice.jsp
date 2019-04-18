<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-18
  Time: 下午 5:31
  To change this template use File | Settings | File Templates.
--%>
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
            margin: 20px auto;
            /*background-color: red;*/
        }
        .inline_to_block{
            display: block;
        }
        .center{
            margin: 10px auto;
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
    <form class="form" action="" method="post">
        <div class="main">
            <p>修改图书馆公告</p>
            <!-- <div>
                <label>时间：</label>
                <input type="text" name="staffId" placeholder="请输入职工ID" required="required">
            </div> -->
            <div>
                <label>内容：</label>
                <textarea name="message" rows="10" cols="20" required="required">
						<!-- 可以在这里添加数据 -->
					</textarea>
            </div>

            <button class="inline_to_block btn center" type="submit">添加</button>
        </div>
    </form>
</div>

</body>
</html>

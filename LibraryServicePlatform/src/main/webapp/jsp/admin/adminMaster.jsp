<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-04-18
  Time: 下午 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Cookie[] cookies = request.getCookies();
    String id="";
    for(Cookie cookie:cookies) {
        if(cookie.getName().equals("adminIdCookie")) {
            id = cookie.getValue();
        }
    }
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
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">

</head>
<body>
<header id="top">
    <!-- 标题展示 -->
    <div id="title">
        <span>图书馆后台管理平台</span>
    </div>
    <!-- 用户名加签到展示 -->
    <div id="user">
        <span><a href="<%=path%>/jsp/admin/adminMaster.jsp">首页&nbsp;&nbsp;</a></span>
        <span>用户名:</span>
        <span><%=id %></span>
        <%--<span><a href="<%=path %>/admin/adminSignIn.do">签到</a></span>--%>
        <%--<span><a href="<%=path %>/jsp/admin/modifyPasswords.jsp">&nbsp;&nbsp;修改密码</a></span>--%>
    </div>

</header>

<div class="middle clear_float">
    <aside class="float_to_left">

        <div id="label">
            <label>导航栏</label>
        </div>
        <ul class="nav nav-tabs nav-stacked">
            <li><a href="<%=path %>/jsp/admin/staffManager.jsp">职工信息管理</a></li>
            <li><a href="<%=path %>/jsp/admin/teachManager.jsp">教师信息管理</a></li>
            <li><a href="<%=path %>/jsp/admin/stuManager.jsp">学生信息管理</a></li>
            <li><a href="<%=path %>/jsp/admin/adminManager.jsp">管理员信息管理</a></li>
            <li><a href="<%=path %>/jsp/admin/bookManager.jsp">书籍资料信息管理</a></li>
            <li><a href="<%=path %>/jsp/admin/libAdviceManager.jsp">图书馆公告管理</a></li>
            <li><a href="<%=path %>/admin/adminLogout.do">退出</a></li>
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
<script type="text/javascript">
    var messages="null";
    messages="<%=msg %>";
    // window.alert(messages);
    if(messages != "null") {
        window.alert(messages);
    }
</script>
</html>

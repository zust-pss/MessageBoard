<%--
  Created by IntelliJ IDEA.
  User: pansi
  Date: 2020/11/1
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body bgcolor="#ddd" style="font-family:Microsoft YaHei" >
<div style="text-align:center;margin-top:120px">
    <h1 >请登录</h1>
    <form action="LoginServlet" method="post">
        <table style="margin-left:40%">
            <caption>用户登录</caption>
            <tr>
                <td>ID：</td>
                <td><input name="id" type="text" size="20"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="20"></td>
            </tr>
        </table>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </form>
    <br>
    <a href="register.jsp">注册</a>
    <%
        if(session.getAttribute("login") != null){
    %>
            <span style="color: red">可直接登陆，不用填写账号密码</span>
    <%
        }
    %>
</div>
</body>
</html>

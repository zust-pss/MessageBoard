<%--
  Created by IntelliJ IDEA.
  User: pansi
  Date: 2020/11/1
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body bgcolor="#ddd" style="font-family:Microsoft YaHei" >
<div style="text-align:center;margin-top:120px">
    <h1 >请注册</h1>
    <form action="RegisterServlet" method="post">
        <table style="margin-left:40%">
            <caption>用户注册</caption>
            <tr>
                <td>ID:</td>
                <td><input name="id" type="text" size="20"></td>
            </tr>
            <tr>
                <td>登录名：</td>
                <td><input name="name" type="text" size="20"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input name="password" type="password" size="20"></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
    <%
        if(request.getAttribute("register") != null){
            if(((String)request.getAttribute("register")).equals("alreadyExist")){
    %>
            <span style="color: red">ID或用户名  已存在，请更换</span>
    <%
            }else if(((String)request.getAttribute("register")).equals("inputError")){
    %>
            <span style="color: red">输入错误请检查</span>
    <%      }
        }
    %>
    <br>
    <a href="login.jsp">登录</a>
</div>
</body>

</html>

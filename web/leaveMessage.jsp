<%--
  Created by IntelliJ IDEA.
  User: pansi
  Date: 2020/11/2
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言界面</title>
</head>

<body bgcolor="#ddd" style="font-family:Microsoft YaHei">
<div style="text-align:center;margin-top:140px">
    <h1 >请留言</h1>
    <form action="LeaveMessageServlet" method="post">
        <table style="margin-left: 37%" border="1">
            <caption>填写留言信息</caption>
            <tr><td>留言标题</td>
                <td><input type="text" name="title"/></td></tr>
            <tr><td>留言内容</td>
                <td><textarea name="message" rows="5" cols="35"></textarea></td>
            </tr>
        </table>
        <input type="submit" value="提交"/>
        <input type="reset" value="重置"/>
    </form>
    <a href="main.jsp">返回留言板界面</a>
</div>
</body>
</html>


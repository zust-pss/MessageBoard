<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.message.entity.MessageBoard" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.message.Dao.impl.LoginDaoImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: pansi
  Date: 2020/11/3
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body bgcolor="#ddd" >
<div style="margin-left:35%;margin-top:100px;font-family:Microsoft YaHei">
    <h1 style="margin-left:5%">个人中心主界面</h1>
    <form>
        <table border="1">
            <caption>我的所有留言信息</caption>
            <tr><th>留言人姓名</th><th>留言时间</th>
                <th>留言标题</th><th>留言内容</th></tr>
            <%
                SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                ArrayList<MessageBoard> al;
                al= (ArrayList<MessageBoard>)request.getAttribute("myMessages");
                if(al!=null){
                    Iterator iter=al.iterator();
                    while(iter.hasNext()){
                        MessageBoard messBoar=(MessageBoard) iter.next();
            %>
            <tr>
                <td><%= new LoginDaoImpl().getNameById(messBoar.getId()) %></td>
                <td><%= sdf.format(messBoar.getTime()) %></td>
                <td><%= messBoar.getTitle() %></td>
                <td><%= messBoar.getMessage() %></td>
                <td><a href="DeleteMessageServlet?messageID=<%=messBoar.getMessageID()%>">删除</a></td>
            </tr>
            <%
                    }
                }

            %>
        </table>
    </form>
    <a style="margin-left:0px" href="QueryMessageByPageServlet">返回</a>
    <a style="margin-left:100px" href="LogoutServlet">退出登陆</a>
</div>
</body>
</html>
<%@ page import="org.message.entity.MessageBoard" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.message.Dao.impl.LoginDaoImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.message.entity.BoardPage" %><%--
  Created by IntelliJ IDEA.
  User: pansi
  Date: 2020/11/1
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板界面</title>
</head>

<body bgcolor="#ddd" >
<div style="margin-left:35%;margin-top:100px;font-family:Microsoft YaHei">
    <h1 style="margin-left:5%">留言板主界面</h1>
    <form>
        <table border="1">
            <caption>所有留言信息</caption>
            <tr><th>留言人姓名</th><th>留言时间</th>
                <th>留言标题</th><th>留言内容</th></tr>
            <%
                SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                BoardPage boardPage;
                boardPage= (BoardPage) session.getAttribute("boardPage");
                ArrayList<MessageBoard> messageBoards = boardPage.getMessages();
                if(messageBoards != null){
                    Iterator iter=messageBoards.iterator();
                    while(iter.hasNext()){
                        MessageBoard messBoar=(MessageBoard) iter.next();
            %>
            <tr><td><%= new LoginDaoImpl().getNameById(messBoar.getId()) %></td>
                <td><%= sdf.format(messBoar.getTime()) %></td>
                <td><%= messBoar.getTitle() %></td>
                <td><%= messBoar.getMessage() %></td></tr>
            <%
                    }
                }
            %>
        </table>
    </form>
    <a style="margin-left:0px" href="leaveMessage.jsp">留言</a>
    <a style="margin-left:150px" href="LogoutServlet">退出登陆</a>
    <a style="margin-left:220px" href="MyselfServlet">个人中心</a><br/>
    <%
        if(boardPage.getCurrentPage() != 1){
    %>
    <a href = "/QueryMessageByPageServlet?currentPage=1">首页</a>
    <a href = "/QueryMessageByPageServlet?currentPage=<%=boardPage.getCurrentPage() - 1%>">上一页</a>
    <%
        }
    %>
    <%
        if(boardPage.getCurrentPage() != boardPage.getTotalPage()){
    %>
    <a href = "/QueryMessageByPageServlet?currentPage=<%=boardPage.getCurrentPage() + 1%>">下一页</a>
    <a href = "/QueryMessageByPageServlet?currentPage=<%=boardPage.getTotalPage()%>">尾页</a>
    <%
        }
    %>
    <br/>
    共<%=boardPage.getTotalCount()+"条留言" + "&nbsp"+ "&nbsp"+ "&nbsp"%>
    <%="当前页："+boardPage.getCurrentPage()+" "+"总页数："+boardPage.getTotalPage()%>
    <br/>
    设置页面留言数
    <form method="post" action="/QueryMessageByPageServlet">
        <select name="pageSize">
            <option value = "3">3</option>
            <option value = "5">5</option>
            <option value = "10">10</option>
        </select>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>


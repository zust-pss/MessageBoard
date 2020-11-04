package org.message.servlet;

import org.message.entity.Login;
import org.message.entity.MessageBoard;
import org.message.service.IMessageService;
import org.message.service.impl.LoginServiceImpl;
import org.message.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LeaveMessageServlet",value = "/LeaveMessageServlet")
public class LeaveMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Login user = (Login) request.getSession().getAttribute("login");
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setId(user.getId());
        messageBoard.setName(user.getName());
        Date utilDate = new Date();
        java.sql.Timestamp t = new java.sql.Timestamp(utilDate.getTime());
        messageBoard.setTime(t);
        messageBoard.setTitle(title);
        messageBoard.setMessage(message);
        IMessageService messageService = new MessageServiceImpl();
        if(messageService.addMessage(messageBoard)){
            response.sendRedirect("success.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

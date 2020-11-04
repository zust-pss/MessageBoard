package org.message.servlet;

import org.message.entity.Login;
import org.message.entity.MessageBoard;
import org.message.service.IMyselfService;
import org.message.service.impl.MyselfServiceImpl;
import org.message.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyselfServlet",value = "/MyselfServlet")
public class MyselfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        Login user = (Login)session.getAttribute("login");
        IMyselfService myselfService = new MyselfServiceImpl();
        ArrayList<MessageBoard> messageBoards;
        messageBoards = myselfService.findAllMyMessage(user.getId());
        request.setAttribute("myMessages",messageBoards);
        request.getRequestDispatcher("myself.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

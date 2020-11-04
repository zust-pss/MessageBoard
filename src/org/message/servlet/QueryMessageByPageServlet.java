package org.message.servlet;

import org.message.entity.BoardPage;
import org.message.entity.MessageBoard;
import org.message.service.IMessageService;
import org.message.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QueryMessageByPageServlet",value = "/QueryMessageByPageServlet")
public class QueryMessageByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        IMessageService messageService = new MessageServiceImpl();
        int count = messageService.getTotalCount();
        int currentPage = 1;
        String cPage = request.getParameter("currentPage");
        if(cPage != null)currentPage = Integer.parseInt(cPage);
        int pageSize = 3;
        String pageS = request.getParameter("pageSize");
        if(pageS != null){
            pageSize = Integer.parseInt(pageS);
            session.setAttribute("pageSize",pageSize);
        }else{
            if(session.getAttribute("pageSize") != null)
            pageSize = (int)session.getAttribute("pageSize");
        }
        ArrayList<MessageBoard> messageBoards = messageService.queryStudentByPage(currentPage,pageSize);
        BoardPage boardPage = new BoardPage();
        boardPage.setCurrentPage(currentPage);
        boardPage.setMessages(messageBoards);
        boardPage.setPageSize(pageSize);
        boardPage.setTotalCount(count);
        session.setAttribute("boardPage",boardPage);
        response.sendRedirect("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

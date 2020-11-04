package org.message.servlet;

import org.message.entity.Login;
import org.message.service.ILoginService;
import org.message.service.IMessageService;
import org.message.service.impl.LoginServiceImpl;
import org.message.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        ILoginService loginService = new LoginServiceImpl();
        HttpSession session=request.getSession();
        Login l = null;
        if(request.getParameter("id") == "" && request.getParameter("password") == ""&& session.getAttribute("login") != null)
            l = (Login) session.getAttribute("login");
        if(l==null && request.getParameter("id") != "" && request.getParameter("password") != ""){
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            l = loginService.checkLogin(id,password);
        }
        if(l!=null){
            session.setAttribute("login",l);
            response.sendRedirect("QueryMessageByPageServlet");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

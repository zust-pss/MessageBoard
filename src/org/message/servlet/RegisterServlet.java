package org.message.servlet;

import org.message.entity.Login;
import org.message.service.ILoginService;
import org.message.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        ILoginService loginService = new LoginServiceImpl();
        int id= -1;
        if(request.getParameter("id") != "")id = Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        if(name == "" || password == ""|| id == -1 ){
            request.setAttribute("register","inputError");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
        if(loginService.insertUser(id,name,password)){
            HttpSession session = request.getSession();
            Login l=new Login(id,name,password);
            session.setAttribute("login",l);
            response.sendRedirect("login.jsp");
        }else {
            request.setAttribute("register","alreadyExist");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

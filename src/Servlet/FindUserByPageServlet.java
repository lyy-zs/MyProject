package Servlet;

import Client.PageBean;
import utils.*;
import Client.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/FindUserByPageServlet")

public class FindUserByPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException  ,IOException {

        //1.获取参数
        String currentPage = req.getParameter("currentPage");//当期页码
        String rows = req.getParameter("rows");//每页显示条数

        if(currentPage==null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "3";
        }
        HttpSession session = req.getSession();


        //获取查询数据
        String name  = req.getParameter("username");

        session.setAttribute("username",name);

//        if(name.length() == 0){
//            name = null;
//        }

        //2.调用service查询
        UserService service = new UserService();
        PageBean<user> pb = service.findUserByPage(currentPage,rows,name);

        //3.将PageBean存入request
        req.setAttribute("pb",pb);
        System.out.println(pb.toString());

        //4.转发到list.jsp
//        req.getRequestDispatcher("../application/adminWindows.jsp").forward(req,resp);
        req.getRequestDispatcher("/application/adminWindows.jsp").forward(req,resp);
//        resp.sendRedirect("/application/adminWindows.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException ,IOException {
        this.doPost(req, resp);
    }
}

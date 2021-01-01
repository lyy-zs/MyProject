package Servlet;

import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adLoginServlet")
public class adLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String adname = req.getParameter("adminName");
        String adpassword = req.getParameter("adminPass");

        boolean flag = UserUtils.isExist(adname,adpassword);
        if(flag == false){
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('用户名或密码错误，请重新输入!');");
            out.print("window.location = 'application/main.jsp';");
            out.print("</script>");
        }
        else{
            System.out.println(flag);
//            resp.sendRedirect("application/adminWindows.jsp");
            resp.sendRedirect("/bank/FindUserByPageServlet");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

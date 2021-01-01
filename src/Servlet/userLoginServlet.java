package Servlet;

import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet( "/userLoginServlet")
public class userLoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String userpassword = req.getParameter("userpass");

        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

        String datetime = date.toString();


        session.setAttribute("username",username);
        session.setAttribute("password",userpassword);


        boolean flag = UserUtils.isUserExist(username,userpassword);

        if(flag == false){
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('用户名或密码错误，请重新输入!');");
            out.print("window.location = 'application/main.jsp';");
            out.print("</script>");
        }
        else{
            System.out.println(datetime);
            UserUtils.UpdateTime(datetime,username);
            System.out.println(flag);
            resp.sendRedirect("application/userwindows.jsp");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

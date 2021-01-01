package Servlet;

import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet( "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String name = req.getParameter("username");
        String password = req.getParameter("userpass");
        String email = req.getParameter("email");

        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

        String datetime = date.toString() ;
        int money = 100;


        System.out.println(name);
        System.out.println(password);
        System.out.println(datetime);

        boolean flag1 = UserUtils.query(name);

        if(flag1 == true){
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('用户名已被注册，请重新输入!');");
            out.print("window.location = 'application/userRegister.html';");
            out.print("</script>");
        }
        else{
            boolean flag = UserUtils.regiseter(name,password,datetime,money,email);
            if(flag == true){
                System.out.println(flag);
                out.print("<script> type = 'text/javascript'>");
                out.print("alert('注册成功！');");
                out.print("window.location = 'application/main.jsp';");
                out.print("</script>");
            }

        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


}

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

@WebServlet( "/DepositServlet")
public class DepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String name = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");

        String smoney = req.getParameter("dmoney");
        int money = Integer.parseInt(smoney);

        System.out.println("存款"+money);
        boolean flag = UserUtils.deposite(name,money);
        if(flag == true){
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('存款成功');");
            out.print("window.location = 'application/userwindows.jsp';");
            out.print("</script>");

        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

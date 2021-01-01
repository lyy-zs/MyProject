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

@WebServlet("/TakeServlet")
public class TakeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String name = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        String tmoney = req.getParameter("tmoney");
        int money = Integer.parseInt(tmoney);

        System.out.println("取款"+money);

        boolean flag = UserUtils.take(name,money);
        if (flag == true) {
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('取款成功');");
            out.print("window.location = 'application/userwindows.jsp';");
            out.print("</script>");
        }
        else{
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('抱歉您账号暂无这么多金额');");
            out.print("window.location = 'application/userwindows.jsp';");
            out.print("</script>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
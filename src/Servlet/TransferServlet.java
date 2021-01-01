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

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        boolean qflag = true,zflag = true;
        String name = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        String zmoney = req.getParameter("zmoney");
        String othername = req.getParameter("othername");

        int money = Integer.parseInt(zmoney);

        qflag = UserUtils.take(name,money);
        if(qflag == true) {
            zflag = UserUtils.deposite(othername, money);
        }
        else{
            zflag = false;
        }
//
//        System.out.println("取款"+money);

//        boolean flag = UserUtils.take(name, money);
        if (qflag == true&&zflag == true) {
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('转款成功');");
            out.print("window.location = 'application/userwindows.jsp';");
            out.print("</script>");
        }else{
            out.print("<script> type = 'text/javascript'>");
            out.print("alert('金额不足,无法转账');");
            out.print("window.location = 'application/userwindows.jsp';");
            out.print("</script>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}

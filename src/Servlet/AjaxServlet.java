package Servlet;

import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");


        String pattern = "[a-zA-Z0-9]*@[a-zA-Z0-9]*.[a-zA-Z0-9]*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        if(!m.matches()) {
            out.print("邮箱不合法");
        } else if(!UserUtils.isExistEmail(email)) {
            out.print("验证通过");
        } else out.print("邮箱已存在");

        out.flush();
        out.close();
    }
}


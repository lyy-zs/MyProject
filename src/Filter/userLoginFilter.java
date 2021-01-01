package Filter;

import com.sun.net.httpserver.HttpPrincipal;
//import jdk.incubator.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter( urlPatterns = {"/application/userwindows.jsp"})

public class userLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpServletRequest request = (HttpServletRequest) req;
        PrintWriter out = resp.getWriter();
        String uri = request.getRequestURI();
        System.out.println(uri);
        if(uri.contains("/userwindows.jsp") || uri.contains("/userLoginServlet")){
            Object user = request.getSession().getAttribute("username");
            if(user != null){
                chain.doFilter(req,resp);
            }else{
                out.print("<script> type = 'text/javascript'>");
                out.print("alert('您尚未登录，请登录!');");
                out.print("window.location = 'main.jsp';");
                out.print("</script>");
//                request.setAttribute("login_msg","您尚未登录，请登录");
                //request.getRequestDispatcher("/application/main.jsp").forward(request,resp);
            }
            //chain.doFilter(req,resp);
            //request.setAttribute("login_msg","您尚未登录，请登录");
//            request.getRequestDispatcher("/application/main.jsp").forward(request,resp);
        }else{
            chain.doFilter(req,resp);

        }

       // chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

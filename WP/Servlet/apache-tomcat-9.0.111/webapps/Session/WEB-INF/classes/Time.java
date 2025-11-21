import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Time extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        boolean loggedIn = false;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("login".equals(cookie.getName()) && "john".equals(cookie.getValue())) {
                    loggedIn = true;
                    break;
                }
            }
        }
        if (loggedIn) {
            pw.println("<b> The time is: " + new java.util.Date() + "</b>");
        } else {
            pw.println("Please login to view this page..");
        }
    }
}
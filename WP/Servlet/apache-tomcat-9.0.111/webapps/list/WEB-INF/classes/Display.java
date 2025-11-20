import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Display extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
pw.println("<ol>");
        pw.println("<li>WP</li>");
        pw.println("<li>MPMC</li>");
        pw.println("<li>DSA</li>");
        pw.println("<li>CN</li>");
        pw.println("<li>DBMS</li>");
        pw.println("</ol>");
}
}

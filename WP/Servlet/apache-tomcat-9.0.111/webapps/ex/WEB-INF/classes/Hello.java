import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Hello extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
pw.println("<h2>Hello from servlets.. </h2>");
}
}

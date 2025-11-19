import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

public class First extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out=res.getWriter();
res.setContentType("text/html");
HttpSession s=req.getSession(true);
String nm=req.getParameter("nm");
s.setAttribute("nm",nm);
out.println("<form action=Second method=get>");
out.println("Enter ur rollno:<input type=text name=rno><br>");
out.println("<input type=submit></form>");
}
}
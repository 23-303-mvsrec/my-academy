import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

public class Final extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out=res.getWriter();
res.setContentType("text/html");
HttpSession s=req.getSession(true);
String nm=(String)s.getAttribute("nm");
String rno=(String)s.getAttribute("rno");
out.println("Name:"+nm+"<br>"+
"Rol No."+rno);
}
}
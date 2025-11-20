import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

public class Second extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out=res.getWriter();
res.setContentType("text/html");
HttpSession s=req.getSession(true);
String rno=req.getParameter("rno");
s.setAttribute("rno",rno);
out.println("Click <a href=Final> Here </a> to view details");
}
}
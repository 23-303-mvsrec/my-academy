import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FindFact extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String s=req.getParameter("t1");
int n=Integer.parseInt(s);
int r=1;
for(int i=1;i<=n;i++)
r=r*i;
pw.println("<h2> the factorial of given number is:"+r+"</h2>");
}
}


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Time extends HttpServlet{
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	Cookie ck[]=req.getCookies();
	boolean b=false;
	if(ck!=null)
	for(int i=0;i<ck.length;i++)
	{
	String s=ck[i].getName();
	String n=ck[i].getValue();
	if(s.equals("login") && n.equals("john"))
	{
	   b=true;
	   break;
	}
	}
	 if(b)
	  {
	   pw.println("<b> The time is:"+new java.util.Date()+"</b>");
	  }
	  else pw.println("Please login to view this page..");
	}}
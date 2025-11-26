<%@ page  import="java.util.Date" session="true" %>
<html>
<head>
    <title>Visit Counter</title>
</head>
<body>

<%
    Date today = new Date();
    if (session.isNew()) {
        session.setAttribute("visitCount", 0);
    }
    else{
        int x = Integer.parseInt(session.getAttribute("visitCount").toString());
        x++;
        session.setAttribute("visitCount", x);
    }
    
%>

<h2>Today's Date & Time: <%= today %></h2>
<h2>You have visited this page <%= count %> times.</h2>

</body>
</html>

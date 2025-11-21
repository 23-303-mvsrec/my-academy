<%!
String nm;
int eno;
double bsal,gsal;
double getGross(double bsal)
{
double gs=bsal+bsal*.30+bsal*0.70;
return gs;
}
%>
<body bgcolor=lightblue>
<%
nm="Smith";
eno=1011;
bsal=10000;
gsal=getGross(bsal);
%>
<table border=1 cellpadding=20>
<tr>
<th> ENAME: </th>
<th><%=nm%></th>
</tr>
<tr>
<th> ENO: </th>
<th><%=eno%></th>
</tr>
<tr>
<th> BASIC: </th>
<th><%=bsal%></th>
</tr>
<tr>
<th> GROSS: </th>
<th><%=gsal%></th>
</tr>
</table>
</center>
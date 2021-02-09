<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="visiterconnection.visiterconnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search By Name</title>
</head>
<body>

	<div>
		<h1>Search By Name</h1>
	</div>
	<form action="searchbyname.jsp" method="post">
		<input type="text" placeholder="Enter Name" name="serchbyname">
		<button type="submit">Search</button>
	</form>

	<%
		String name = request.getParameter("serchbyname");
	Connection con = visiterconnection.getConnection();
	PreparedStatement pst = con.prepareStatement("select * from register where name='" + name + "'");
	ResultSet rs = pst.executeQuery();
	int n = 1;
	%>
	<table align="center" border="1">

		<tr>
			<td>Sr.No</td>
			<td>Visitor Full Name</td>
			<td>Visitor Qualification</td>
			<td>Visitor Contact</td>
			<td>Visitor Email</td>
			<td>Visitor Address</td>
			<td>Reason of Visit</td>
			<td>Date</td>
			<td>Delete</td>


		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=n%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>
			<td><%=rs.getDate(8)%></td>
			<td><button onclick="myfun(<%=rs.getString(1)%>)">Delete</button></td>
		</tr>
		<%
			n++;
		}
		%>
	</table>

	<script type="text/javascript">
function myfun(n) {
	var x=n;
	
	var a=confirm('Are you sure you wants to delete');
	if(a==true){
		window.location='deletecontroler?id='+x;
	}
	
}
</script>

</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<form action="register" method="post">
		<table align="center" border="1">
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" name="name"
					placeholder="Enter Visiter Name" required="required"></td>
			</tr>
			<tr>
				<td><label>Qualification</label></td>
				<td><input type="text" name="qualification"
					placeholder="Enter Visiter Qualification" required="required"></td>
			</tr>
			<tr>
				<td><label>Contact</label></td>
				<td><input type="text" name="contact"
					placeholder="Enter Visiter Contact" maxlength="10"
					pattern="^\d{10}$" required="required"></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email"
					placeholder="Enter Visiter Email" required="required"></td>
			</tr>
			<tr>
				<td><label>Address</label></td>
				<td><input type="text" name="address"
					placeholder="Enter Visiter Address" required="required"></td>
			</tr>
			<tr>
				<td><label>Reason</label></td>
				<td><input type="text" name="reason"
					placeholder="Enter Visiter Reason" required="required"></td>
			</tr>
		</table>
		<div align="center">
			<button>Submit</button>
		</div>
	</form>
</body>
</html>
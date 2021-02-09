<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Details</title>
</head>
<body>

	<form action="Company" method="post">
		<table align="center" border="1">
			<tr>
				<td><label>Comapny Name</label></td>
				<td><input type="text" name="company_name" required="required"></td>
			</tr>
			<tr>
				<td><label>Company Email</label></td>
				<td><input type="text" name="company_email" required="required"></td>
			</tr>
			<tr>
				<td><label>Company Address</label></td>
				<td><input type="text" name="company_address"
					required="required"></td>
			</tr>
		</table>
		<div align="center">
			<button>Submit</button>
		</div>
	</form>
</body>
</html>
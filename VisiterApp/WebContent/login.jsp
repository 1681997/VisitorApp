<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
 
	<form action="login" method="post">
		<table align="center" border="1">
			<tr>
				<td><label>ID</label></td>
				<td><input type="text" name="email"
					placeholder="Enter Email/ID" required="required"></td>
			</tr>
			<tr>
				<td><label>PASSWORD</label></td>
				<td><input type="password" name="pass"
					placeholder="Enter Password" required="required"></td>
			</tr>
		</table>
		<div align="center">
			<button>Login</button>
		</div>
	</form>
</body>
</html>
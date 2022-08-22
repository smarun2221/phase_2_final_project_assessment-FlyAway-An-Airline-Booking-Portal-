<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body >
<br>
<p align="center">
<a href=Homepage.jsp style="color:Red; font-size:20px;font-weight:bold;">FlyAway</a>
</p>
<br><br>

<h2 align="center">User Login</h2>
<div align="center">
<form action=Userlogin method=post >
    <table >
    <tr>
    <td><label for=email>Email</label><br></td>
    <td><input type="email" name=email id=email /></td>
    </tr>
    <tr>
    <td><label for=pass>Password</label><br></td>
    <td><input type="password" name=password id=pass /></td>
    </tr>
    
    <tr>
    <td><input type=submit value=submit /></td>
    <td><input type=reset /></td>
    </tr>
    </table>
	
</form>
</div>

<br><br>

<h4 align="center"><a href=Userregistration.jsp style="font-size:25;color:blue;">New User ? Create a new FlyAway Account</a></h4>

<%
	String message=(String)session.getAttribute("message");
	if(message!=null){
%>
<p style="color:silver;"><%=message %></p>
<%
		session.setAttribute("message", null);
	}
%>
</body>
</html>
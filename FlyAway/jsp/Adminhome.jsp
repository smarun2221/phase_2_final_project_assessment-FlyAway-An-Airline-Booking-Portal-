<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body >
<br>
<p align="center">
<a href=Homepage.jsp style="font-size:35px;font-weight:bold;">FlyAway Air ticket booking</a>
</p>
<br><br>
<h1 align="center"> Add a new Flight</h1>
<div align="center">
<form action=Insertflight method=post>
	<label for=name>Flight Name </label> <input type="text" name=name id=name /><br><br>
	<label for=fromf>From </label> <input type="text" name=fromf id=fromf /><br><br>
	<label for=tof>To </label> <input type="text" name=tof id=tof /><br><br>
	<label for=datef>Departure </label> <input type="date" name=datef id=datef /><br><br>
	<label for=timef>Time </label> <input type="time" name=timef id=timef /><br><br>
	<label for=price>Price </label> <input type="text" name=price id=price /><br><br>
	<input type=submit value=Submit /> <input type=reset>
</form>
</div>
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
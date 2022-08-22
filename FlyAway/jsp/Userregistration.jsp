<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<br>
<p align="center">
<a href=Homepage.jsp style="color:Red;text-decoration:none ; font-size:25px;font-weight:bold;">FlyAway</a>
</p>
<br><br>

<div align="center">
<form action=Userregistration method=post>
	<label for=email>Email </label> <input type="email" name=email id=email /><br><br>
	<label for=pass>Password </label> <input type="password" name=password id=pass /><br><br>
	<label for=name>Name </label> <input type="text" name=name id=name /><br><br>
	<label for=phno>Phone Number </label> <input type="text" name=phno id=phno /><br><br>
	<label for=adno>Aadhaar Number </label> <input type="text" name=adno id=adno /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>
</div>

</body>
</html>
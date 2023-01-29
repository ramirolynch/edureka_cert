<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Banking System</title>
</head>
<body>
<form action="search" method="post">
<h1>Banking System</h1>
<label>User Name:</label>
<input type="number" name="id" id="id" required><br><br>
<label>Password:</label>
<input type="password" name="password" id="password" required><br><br>
<input type="submit" value="Submit" onclick="getUserDetails()">
</form>
<h2 id="user-id"></h2>

</body>
</html>
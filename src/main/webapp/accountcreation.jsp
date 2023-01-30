<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Account Creation Screen</title>
</head>
<body>
<form action="create-account" method="post">
<h1>Account Creation Screen</h1>
<label>Name:</label>
<input type="text" name="name" id="name" required><br><br>
<label>Date of Birth:</label>
<input type="date" name="dob" id="dob" required><br><br>
<label>Address:</label><br>
<textarea id="address" name="address" rows="4" cols="50"></textarea>
<br><br>
<label>Email Id:</label>
<input type="email" name="email" id="email" required><br><br>
<label for="accounttype">Type of Account:</label>
<select name="accounttype" id="accounttype">
  <option value="default" selected>Select Account Type</option>
  <option value="savings">Savings Account</option>
  <option value="checking">Checking Account</option>
</select><br><br>
<input type="submit" value="Create Account">
</form>


</body>
</html>
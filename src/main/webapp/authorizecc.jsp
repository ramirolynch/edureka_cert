<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Authorize Credit Card Transaction</title>
</head>
<body>
<form action="authorize" method="post">
<h1>Authorize Credit Card Transaction</h1>
<label>Name:</label>
<input type="text" name="name" id="name" required><br><br>
<label>Card Number:</label>
<input type="number" name="ccnum" id="ccnum" required><br><br>
<label>CVV2/CVC2:</label><br>
<input type="number" name="cvv" id="cvv" required><br><br>
<label>Amount:</label><br>
<input type="number" name="amt" id="amt" required><br><br>
<input type="submit" value="Authorize">
</form>


</body>
</html>
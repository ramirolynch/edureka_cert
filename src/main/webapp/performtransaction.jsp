<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Perform Debit or Credit operation</title>
</head>
<body>
<form action="create-account" method="post">
<h1>Perform Debit or Credit operation</h1>
<label>Account Number:</label>
<input type="number" name="acc" id="acc" required><br><br>
<label>Amount:</label>
<input type="number" name="amt" id="amt" required><br><br>

<input type="submit" value="Debit From">
<input type="submit" value="Credit To">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="myCertification.bank.dto.Transaction"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions</title>
</head>
<body>

<h3> Transaction Information </h3>
 <%  List<Transaction> txs = (ArrayList<Transaction>) request.getAttribute("transactions");%>
 <%
Object userIdObject = session.getAttribute("id");
long userId = (long)userIdObject;
%>
<%
    for(Transaction tx : txs)
    {
        out.print("Transaction Date: " + tx.getDateTx());
        out.print(" Description: " + tx.getDescription());
        out.print(" Amount: " + tx.getAmount());
        if(tx.getAccountTo()!=null) {
        out.print(" Account To: " + tx.getAccountTo());
        out.print(" Account From: " + userId);
        }
        if (tx.getAccountFrom()!=null) {
            out.print(" Account From: " + tx.getAccountFrom());
            out.print(" Account To: " + userId);
         }
         out.print("<br/>");
    }
%>

</body>
</html>



<%@page import="com.spring.Entity.Expense"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expense List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f7;
            margin: 0;
            padding: 20px;
        }
        .container {
            width: 90%;
            max-width: 800px;
            margin: 40px auto;
            background-color: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table thead {
            background-color: #28a745;
            color: white;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: left;
        }
        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .no-data {
            text-align: center;
            color: gray;
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Expense List</h2>

    <table>
        <thead>
            <tr>
                 <th>Exp id</th>
                <th>Expense Name</th>
                <th>Amount (₹)</th>
                <th>Description</th>
                <th>Expense added Date</th>
				<th>Last Updated On Date</th>
				
            </tr>
        </thead>
        
        <%
           List<Expense> expList  = (List<Expense>)request.getAttribute("exp");
        
        for(Expense e:expList){
        %>
        <tr>
        <td><%=e.getEid()%> </td>
        <td><%=e.getName()%> </td>
        <td><%=e.getAmount()%> </td>
        <td><%=e.getDesciption()%> </td>
        <td><%=e.getCreatedDate()%> </td>
        <td><%=e.getUpdatedDate()%> </td>

        
        
        </tr>
        <%
        }
        %>
        <tbody>
         
         
         
         
        </tbody>
    </table>
</div>

</body>
</html>

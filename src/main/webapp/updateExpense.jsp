<%@page import="com.spring.Entity.Expense"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Expense</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 80px auto;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #2c3e50;
        }
        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        textarea {
            resize: vertical;
            min-height: 80px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #28a745; /* Green */
            color: white;
            padding: 12px;
            border: 2px solid #28a745;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }
        input[type="submit"]:hover {
            background-color: white;
            color: #28a745;
            border: 2px solid #28a745;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Update Expense</h2>
    <form action="/update" method="post">
       
     	<label for="expenseId">Expense Id:</label>
        <input type="text" id="expenseId" name="eid" readonly="readonly" value="${exp.eid}" required />

        <label for="name">Expense Name</label>
        <input type="text" id="name" name="name" value="${exp.name}" required>

        <label for="amount">Amount (₹)</label>
        <input type="number" id="amount" name="amount" value="${exp.amount }" step="0.01" required>

        <label for="description">Description</label>
        <input type="text" id="description" name="desciption" value="${exp.desciption }" >
        
      

        <input type="submit" value="Update Expense">
    </form>
</div>



</body>
</html>


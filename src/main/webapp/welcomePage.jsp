<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome - Expense Tracker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f1f1f1;
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            padding: 100px 20px;
        }
        h1 {
            color: #2c3e50;
        }
        .nav-links {
            margin-top: 40px;
        }
        .nav-links a {
            display: inline-block;
            margin: 10px 20px;
            padding: 15px 25px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .nav-logout a {
            display: inline-block;
            margin: 10px 20px;
            padding: 15px 25px;
            background-color: #2f5e87;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .nav-links a:hover {
            background-color: #218838;
        }
         .nav-logout a:hover {
            background-color: #ed001f;
        }
        .nav-logout{
        margin-top:70px;
        }
    </style>
</head>
<body>

<div class="container">

    <h1>Welcome to Your Expense Tracker</h1>
    <h4 style="color: green">${msg}</h4>
    <p>Manage your expenses easily and efficiently.</p>

    <div class="nav-links">
        <a href="addexp">Add Expense</a>
        <a href="updatelist">Update Expense</a>
        <a href="Expenselist">Expense List</a>
    </div>
     <div class="nav-logout">
        
        <a href="logout">Logout</a>
        
      
    </div>
    
</div>

</body>
</html>

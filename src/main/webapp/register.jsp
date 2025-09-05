<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e9ecef;
        }
        .register-container {
            width: 350px;
            margin: 80px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
        }
        .register-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .register-container label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }
        .register-container input[type="text"],
        .register-container input[type="email"],
        .register-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        .register-container input[type="submit"] {
            width: 100%;
            background-color: #28a745; /* Green color */
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }
        .register-container a{
         text-decoration: none;	
        }
        .register-container input[type="submit"]:hover {
            background-color: #218838; /* Darker green on hover */
        }
    </style>
</head>
<body>

<div class="register-container">
    <h2>Register</h2>
    <form action="register" method="post">
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" required>

        <label for="username">Username</label>
        <input type="text" id="username" name="userName" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <input type="submit" value="Register">
        
    </form>
    <br>
        	<a>Already have Account ?<a href="loginpage">login </a></a>
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="login.css">
    <title>Login</title>
</head>
<body>

    <div class="form-container log-in-container">
        <form class="login-form" action="login" method="post">
            <input value="" type="text" name="email" placeholder="Email" required/>
            <input type="password" name="password" placeholder="Password" required/>
            <a href="#">Forgot your password ?</a>
            <button class="login-btn" type="submit">Log In</button>

        </form>
    </div>
</body>
</html>
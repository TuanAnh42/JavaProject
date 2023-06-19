<%-- 
    Document   : Login
    Created on : Jun 15, 2023, 10:04:58 PM
    Author     : Tuấn Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="POST" action="LoginSvl">
            <h1>Login</h1>
            <label>Username:</label>
            <input required name="Username"><br><br>
            <label>Password:</label>
            <input required name="Password" type="password"><br><br>
            <input type="submit" value="Login">
            <input type="reset" value="Reset">
            <br><br>
            <a href="Register.jsp">Create a new account?</a>
        </form>

    </body>
</html>

<%-- 
    Document   : Register
    Created on : Jun 15, 2023, 10:04:50 PM
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
        <form method="POST" action="RegisterSvl">
            <h1>REGISTER</h1>
            <label >Username:</label>
            <input required name="Username"><br><br>
            <label>Password:</label>
            <input required name="Password"><br><br>
            <label>Email:</label>
            <input required name="Email"><br><br>
            <label>Address:</label>
            <textarea required name="Address"></textarea><br><br>
            <input type="submit" value="Register" >
            <input type="reset" value="Reset">

            <br><br>
        </form>
    </body>
</html>

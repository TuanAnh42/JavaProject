<%-- 
    Document   : Register
    Created on : Jun 18, 2023, 11:13:32 PM
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
        <h1>Input Your Information</h1>
        <form method="POST" action="CookieRegis">

            <label>Firstname:</label>
            <input name="firstname" ><br><br>
            <label>Lastname:</label>
            <input name="lastname"><br><br>
            <label>Enter Password:</label>
            <input name="password"><br><br>
            <label>Re-Enter Password:</label>
            <input name="repass" ><br><br>
            <input type="submit" value="Display">
            <input type="Reset" value="Reset">
        </form>
        <div>
        <% String errorMessage = (String) request.getAttribute("errorMessage");
       
        if (errorMessage != null) { %>
            <p style="color: red;"><%= errorMessage %></p>
            
        <% } %>
    </div>
    </body>
</html>

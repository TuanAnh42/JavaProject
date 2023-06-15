<%-- 
    Document   : Home
    Created on : Jun 15, 2023, 11:57:27 PM
    Author     : Tuấn Anh
--%>

<%@page import="entity.User"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%         
            User user = (User) session.getAttribute("user");

            if (user == null) {
                // User information doesn't exist in the session, redirect to login form
                response.sendRedirect("Login.jsp");
            } else {
                // User information exists in the session, display greeting message
                String username = user.getUsername();
        %>
        <h2>Welcome, <%= username%>!</h2>

        <%
            }
        %>
        <a href="LogoutSvl">Log out</a>

        
    </body>
</html>

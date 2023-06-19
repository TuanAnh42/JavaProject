<%-- 
    Document   : home
    Created on : Jun 19, 2023, 12:00:22 AM
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
        <h1>Welcome to the Home Page</h1>

        <h2>User Info:</h2>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("lastname")) {
                        String lastname = cookie.getValue();
            
            %>
            <p>LastName: <%= lastname%></p>
            
            <%
                }else if (cookie.getName().equals("firstname")) {
                             String   firstname = cookie.getValue();
        
        %>
        <p>FirstName: <%= firstname%></p>
        <%
                    }
                }
            }
        %>
    </body>
</html>

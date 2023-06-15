<%-- 
    Document   : Update
    Created on : Jun 9, 2023, 5:37:01 AM
    Author     : Tuấn Anh
--%>

<%@page import="entity.Contactad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="ContactSvl">
           
            <% Contactad contact = (Contactad) request.getAttribute("contact");%>

            <input type="hidden" name="contactId" value="<%= contact.getId()%>">

            <label>FirstName</label>
            <input type="text" name="firstName" value="<%= contact.getFirstname()%>"><br>

            <label>LastName</label>
            <input type="text" name="lastName" value="<%= contact.getLastname()%>"><br>

            <label>PhoneNumber</label>
            <input type="text" name="phoneNumber" value="<%= contact.getPhoneNumber()%>"><br>

            <button type="submit">Update</button>
        </form>

    </body>
</html>

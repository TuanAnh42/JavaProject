<%-- 
    Document   : add_contact
    Created on : Jun 9, 2023, 3:43:06 PM
    Author     : teacher
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Group"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div style="padding-left: 50%">
            <h1>Add a Contact</h1>
            <form action="AddContactServlet" method="POST">
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="first_name"></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="last_name"></td>
                    </tr>
                    <tr>
                        <td>Group:</td>
                        <td>
                            <select name="groupId">
                                <c:forEach var="fg" items="groups">
                                    <option value="${fg.id}">${fg.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type="text" name="phone_number"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Add"></td>
                        <td><a href="url" target="_blank">Return To Contact List</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

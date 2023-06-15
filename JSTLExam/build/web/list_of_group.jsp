<%-- 
    Document   : list_of_group
    Created on : Jun 7, 2023, 4:32:26 PM
    
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Group"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table,tr,td,th{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>

    </head>
    <body>
        

        <div style="padding-left: 50%">
            <h1>List Of Group</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="groups" var="group">
                <tr>
                    <td>${group.id}</td>
                    <td>${group.name}</td>
                    <td>${group.description}</td>
                </tr>
            </c:forEach>
            </table>
            <a href="add_group.jsp" target="_blank">Add Group</a>
            <a href="ListGroupsServlet" target="_blank">List Contact</a>
        </div>
    </body>
</html>

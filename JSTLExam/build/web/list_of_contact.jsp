<%-- 
    Document   : list_of_contact
    Created on : Jun 9, 2023, 2:05:52 PM
    Author     : teacher
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Contact"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Group"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table,th,td{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>List Of Contacts</h1>
        <p>There are contacts in the List</p>
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Group</th>
                <th>Phone Number</th>
                <th>Operations</th>
            </tr>
            <c:forEach var="contact" items="${contacts}">
                <tr>
                    <td>${contact.id}</td>
                    <td>${contact.firstName}</td>
                    <td>${contact.lastName}</td>
                    
                    <td>${contact.phoneNumber}</td>
                    <c:forEach var="group" items="${groups}">
                        if (group.Id() == contact.GroupId()) {

                        <td>group.Name()</td>
                        }
                    </c:forEach>
                    <td><a href="editcontact?id=${contact.id}">Edit</a></td>
                    <td><a href="deletecontact?id=${contact.id}">Delete</a></td>
                    
                    <td></td>
                </tr>

            </c:forEach>

            
        </tr>

        
    </table>
    <a href="add_contact.jsp" target="_blank">Add Contact</a>
    <a href="url" target="_blank">List Group</a>

</body>
</html>

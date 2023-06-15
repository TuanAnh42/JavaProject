<%-- 
    Document   : list_of_group
    Created on : Jun 7, 2023, 4:32:26 PM
    Author     : teacher
--%>

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
        <%
            ArrayList<Group> groups = new ArrayList<>();
            groups = (ArrayList<Group>) request.getAttribute("groups");
        %>
        <h1>LIST OF GROUP</h1>
        <div>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                    <%for (Group group : groups) {%>
                    <tr>
                        <td><%=group.getId()%></td>
                        <td><%=group.getName()%></td>
                        <td><%=group.getDescription()%></td>
                    </tr>
                    <%}%>
                </table>
                <tr>
                    <td><a href="add_group.jsp">Add Group</td>
                </tr>
        </div>

    </body>
</html>

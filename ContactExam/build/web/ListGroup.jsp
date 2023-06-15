<%-- 
    Document   : ListGroup
    Created on : Jun 7, 2023, 12:29:48 AM
    Author     : Tuấn Anh
--%>

<%@page import="entity.FriendGroup"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET" action="ContactSvl">
        <%
            List<FriendGroup> groupList =(List<FriendGroup>) request.getAttribute("groupList");
            %>
        
            
        <h1>List Of Group</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Group Name</th>
                <th>Description</th>
            </tr>
            <% for(FriendGroup std: groupList){%>
            <tr>
                     <td><%=std.getId()%></td>
                     <td><%=std.getName()%></td>
                     <td><%=std.getDescription()%></td>
            </tr>
            <%}%>
        </table><br>
        <button name="btnActionAddGroup" value="ActionAddGroup">Add Group </button>
        <button name="btnBackListContact" value="BackListContact">List Contact </button>
        </form>
    </body>
</html>

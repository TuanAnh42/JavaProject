<%-- 
    Document   : add_group.jsp
    Created on : Jun 7, 2023, 4:57:55 PM
    Author     : teacher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="padding-left: 50%">
            <h1>Add A Group</h1>
            <form action="AddGroupServlet" method="POST">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name_group"></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="description"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="name" value="Add"></td>
                        <td><a href="ListGroupsServlet" target="target">Return To Group List</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>

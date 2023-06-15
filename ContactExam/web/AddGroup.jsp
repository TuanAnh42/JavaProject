<%-- 
    Document   : AddGroup
    Created on : Jun 7, 2023, 12:41:42 AM
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
        <form method="POST" action="ContactSvl">
        <h1>Hello World!</h1>
        <label>Name</label>
        <input required name="name"><br><br>
        <label>Description</label>
        <input required name="description"><br><br>
        <button type="submit" name="btnAddGroup" value="add">Add</button>
        <button name="btnReturn" value="return">Return to Group List</button>
        </form>
    </body>
</html>

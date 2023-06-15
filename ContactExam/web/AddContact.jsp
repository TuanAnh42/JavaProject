<%-- 
    Document   : AddContact
    Created on : Jun 6, 2023, 9:47:57 PM
    Author     : Tuấn Anh
--%>

<%@page import="entity.FriendGroup"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AddGroup"%>
<%@page import="model.AddContact"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="ContactSvl" method="POST">
        
        <h1 >Add a Contact</h1>
        <%
            List<FriendGroup> groupList = (List<FriendGroup>) request.getAttribute("groupList");
        %>
        
            <label>FirstName</label>
            <input type="text" id="firstname" name="firstname"><br><br>
            <label>LastName</label>
            <input type="text" id="lastname" name="lastname"><br><br>
            <label>Group</label>
            <select>
            <% for (FriendGroup groupstd : groupList) {%>
            
                <option value="<%=groupstd.getId()%>"><%=groupstd.getName()%>
                </option>
            
            <% } %>
            </select>
            <br><br> 
            <label>PhoneNumber</label>
            <input type="text" id="phone" name="phone"><br><br>
            <button type="submit" name="btnAddContact" value="AddContact">Add</button>
            <button name="btnReturnContactList" value="ReturnContactist">Return To Contact List</button>
        </form>

    
</html>

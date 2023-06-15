<%-- 
    Document   : Edit
    Created on : Jun 14, 2023, 12:51:54 PM
    Author     : Tuấn Anh
--%>

<%@page import="entity.Contact"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Contact" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <% Contact contact = (Contact) request.getAttribute("contact");%>
        <form action="editcontact" method="post">

            <label>Id</label>
            <input type="text" readonly name="id" value="${contact.id}"><br><br>
            <label>First Name</label>
            <input type="text" name="firstname" value="${contact.firstName}"><br><br>           
            <label>Last Name</label>
            <input type="text" name="lastname" value="${contact.lastName}">

            <select name="groupId">
                <c:forEach var="fg" items="groups">

                    <c:when test="${fg.id == contact.groupId}">
                        <option selected value="${fg.id}">${fg.name}</option>

                        <option value="${fg.id}">${fg.name}</option>
                    </c:when>

                </c:forEach>
            </select><br><br>  

            <label>Phone Number</label>
            <input type="text" name="phonenumber" value="${contact.phoneNumber}"><br><br>  

            <input type="submit" value="Submit">

        </form>
        <a href="contactlist">
            <button>Contact List</button>
        </a>
    </body>
</html>


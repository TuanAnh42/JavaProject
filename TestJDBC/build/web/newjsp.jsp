<%-- 
    Document   : newjsp
    Created on : Jun 5, 2023, 2:54:52 PM
    Author     : Tuấn Anh
--%>
<%@page import="java.util.List"%>
<%@page import="entity.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Student> studentList =(List<Student>) request.getAttribute("studentList");
            %>
        <h1>Hello World!</h1>
        <table border="1" >
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>MarkAvg</th>
            </tr>
            <% for(Student std:studentList){%>
            <tr>
                     <td><%=std.getId()%></td>
                     <td><%=std.getName()%></td>
                     <td><%=std.getAge()%></td>
                     <td><%=std.isGender()==true?"Male":"Female"%></td>
                     <td><%=std.getPhone()%></td>
                     <td><%=std.getEmail()%></td>
                     <td><%=std.getAddress()%></td>
                     <td><%=std.getMarkAvg()%></td>
                     </tr>
            <%}%>
             
<!--                 c:forEach var= "std" items= "${studentList}">
                     <tr>
                     <td>${std.id}</td>
                     <td>${std.name}</td>
                     <td>${std.age}</td>
                     <td>${std.gender}</td>
                     <td>${std.phone}</td>
                     <td>${std.email}</td>
                     <td>${std.address}</td>
                     <td>${std.markAvg}</td>
                     </tr>
                 /c:forEach>-->
            
            
        </table>
    </body>
</html>

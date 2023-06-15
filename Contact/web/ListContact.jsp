<%-- 
    Document   : ListContact
    Created on : Jun 6, 2023, 11:27:17 PM
    Author     : Tuấn Anh
--%>


<%@page import="java.util.List"%>
<%@page import="entity.Contactad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <% 
            List<Contactad> contactList = (List<Contactad>) request.getAttribute("contactList");
        %>
        <h1 style="text-align: center">List Of Contact</h1>
        
        <table>    
            <thead>
                <tr>
                    <th>Id</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Group</th>
                    <th>PhoneNumber</th>
                    <th>Operations</th>                    
                </tr>
            </thead>
            <% for(Contactad std: contactList){%>
            <tbody>
                   <tr>
                     <td><%=std.getId()%></td>
                     <td><%=std.getFirstname()%></td>
                     <td><%=std.getLastname()%></td>
                    <td><%=std.getFirstname()%></td>
                    <td><%=std.getPhoneNumber()%></td>
                    <td>
                        <button name="btnEdit" value="edit" id="bt1">edit</button>
                        <button name="btnRemove" value="remove" id="bt2">remove</button>
                        </td>
                     
            </tr> 
            </tbody>
            <%}%>
        </table>
        
            
        <button name="btnActionAddContact" value="ActionAddContact">Add Contact</button>
        <button name="btnActionListGroup" value="ActionListGroup">List Group</button>
        
        
    </body>
    <script>
        document.addEventListener("Loaded",funtion(){
        var table = document.getElementById("ID");
        
        if (table.rows.length <= 1) {
            document.getElementById("bt1").style.display = "none";
            document.getElementById("bt2").style.display = "none";
        })
    </script>
</html>

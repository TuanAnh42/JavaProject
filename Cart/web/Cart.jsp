<%-- 
    Document   : Cart
    Created on : Jun 19, 2023, 2:36:56 PM
    Author     : Tuấn Anh
--%>

<%@page import="model.CartModel"%>
<%@page import="java.util.List"%>
<%@page import="entity.CartInf"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Cart"%>
<%@page import="entity.AddProduct"%>
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
            List<CartInf> cartList = (List<CartInf>) request.getAttribute("cartList");
        %>
        <form action="CartServlet" method="Post">
            <label>Chọn sản phẩm:</label>
            <select>
                <c:forEach var="product" items="${cartList}">         
                    <option value="${product.masp}">${product.tensp}</option>                
                </c:forEach>
            </select>

            <label>SỐ lượng:</label>
            <input name="quantity">
            <input type="submit" value="Mua Hàng">
            <button>In Hoá Đơn</button>
            <h1>CHI TIẾT GIỎ HÀNG</h1>   

            <table border="1">  
                <tr>

                    <th>MSSP</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>Đơn Giá</th>
                        <%
                            Cart carts = (Cart) session.getAttribute("cart");
                            if (carts != null) {
                                ArrayList<AddProduct> list = carts.cart();
                                for (AddProduct product : list) {
                                    List<CartInf> inf = new CartModel().getAll();
                        %>
                <tr>
                    <td><%=product.getMaproduct()%></td>
                    <td><%=inf%></td>
                    <td><%=product.getSoluong()%></td>
                    <td><%=product.getDongia()%></td>
                </tr>
                <%
                    }
                %>
                <h2 align="right">Tổng tiền:<%=carts.Total()%></h2>
                <%} %>
                </tr>
                <%
                    Cart carts = (Cart) session.getAttribute("cart");
                    if (carts != null) {
                        ArrayList<AddProduct> list = carts.getProducts();
                        double totalAmount = 0; // Tổng tiền

                        for (AddProduct product : list) {
                            List<CartInf> inf = new CartModel().getAll();

                            // Tính thành tiền của sản phẩm (số lượng mua * đơn giá)
                            double amount = product.getSoluong() * product.getDongia();
                            totalAmount += amount; // Cộng vào tổng tiền
                %>
                <tr>
                    <td><%= product.getMaproduct()%></td>
                    <td><%= product.getTensanpham()%></td>
                    <td><%= product.getSoluong()%></td>
                    <td><%= product.getDongia()%></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="3" align="right">Tổng tiền:</td>
                    <td><%= totalAmount%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </form>
    </body>
</html>

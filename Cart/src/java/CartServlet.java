/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import entity.AddProduct;
import entity.Cart;
import entity.CartInf;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CartModel;

/**
 *
 * @author Tuấn Anh
 */
@WebServlet(urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<CartInf> cartList = new ArrayList<>();
            cartList = new CartModel().getAll();
            request.setAttribute("cartList", cartList);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quantityStr = request.getParameter("quantity");
    
    if (quantityStr != null && quantityStr.matches("\\d+")) {
        int quantity = Integer.parseInt(quantityStr);
        
        String selectedProductId = request.getParameter("selectedProduct");
        
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        
        boolean productExists = false;
        for (AddProduct product : cart.getProducts()) {
            if (product.getMaproduct().equals(selectedProductId)) {
                product.setSoluong(product.getSoluong() + quantity);
                productExists = true;
                break;
            }
        }
        
        if (!productExists) {
            AddProduct newProduct = new AddProduct();
            newProduct.setMaproduct(selectedProductId);
            newProduct.setSoluong(quantity);
            cart.getProducts().add(newProduct);
        }
    }
    
    response.sendRedirect("Cart.jsp");
}
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

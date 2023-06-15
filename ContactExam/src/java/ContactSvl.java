/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import entity.Contactad;
import entity.FriendGroup;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AddContact;
import model.AddGroup;

/**
 *
 * @author Tuấn Anh
 */
@WebServlet(urlPatterns = {"/ContactSvl"})
public class ContactSvl extends HttpServlet {

    private static final String ADDCONTACT = "AddContact.jsp";
    private static final String LISTCONTACT = "ListContact.jsp";
    private static final String ADDGROUP = "AddGroup.jsp";
    private static final String LISTGROUP = "ListGroup.jsp";
    private static final String ERROR = "invalid.html";
    private static final String EDIT = "Update.jsp";

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
        String url = ERROR;

        try {
            String action = request.getParameter("btnAddContact");
            if (action != null && action.equals("AddContact")) {
                url = LISTCONTACT;
                return;
            }
            String returncontact = request.getParameter("btnReturnContactList");
            if (returncontact != null && returncontact.equals("ReturnContactist")) {
                url = LISTCONTACT;

            }
            String listcontact = request.getParameter("btnActionAddContact");
            if (listcontact != null && listcontact.equals("ActionAddContact")) {
                url = ADDCONTACT;

            }
            String listgroup = request.getParameter("btnActionListGroup");
            if (listgroup != null && listgroup.equals("ActionListGroup")) {
                url = LISTGROUP;

            }
            String addgroup = request.getParameter("btnAddGroup");
            if (addgroup != null && addgroup.equals("add")) {
                url = LISTGROUP;

            }
            String returnlistgroup = request.getParameter("btnReturn");
            if (returnlistgroup != null && returnlistgroup.equals("return")) {
                url = LISTGROUP;

            }
            String actionaddgroup = request.getParameter("btnActionAddGroup");
            if (actionaddgroup != null && actionaddgroup.equals("ActionAddGroup")) {
                url = ADDGROUP;

            }
            String backlistcontact = request.getParameter("btnBackListContact");
            if (backlistcontact != null && backlistcontact.equals("BackListContact")) {
                url = LISTCONTACT;

            }
            String edit = request.getParameter("btnEdit");
            if (edit != null && edit.equals("edit")) {
                url = EDIT;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);

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

        ArrayList<FriendGroup> groupList = new AddGroup().getAll();

        request.setAttribute("groupList", groupList);
        ArrayList<Contactad> contactList = new AddContact().getAll();

        request.setAttribute("contactList", contactList);
        try {
            String editId = request.getParameter("btnEdit");
            if (editId != null && !editId.isEmpty()) {
                // Lấy thông tin liên hệ cần chỉnh sửa dựa trên tham số editId
                int id = Integer.parseInt(editId);
                Contactad contactToEdit = getContactById(id);

                request.setAttribute("contactToEdit", contactToEdit);
            }

            String deleteId = request.getParameter("btnRemove");
            if (deleteId != null && !deleteId.isEmpty()) {
                int id = Integer.parseInt(deleteId);
                // Gọi phương thức delete từ class AddContact để xoá dòng có id tương ứng
                AddContact addContact = new AddContact();
                addContact.delete(id);
                System.out.println("sdfdssgdfg");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        processRequest(request, response);

    }

    private Contactad getContactById(int id) {
        ArrayList<Contactad> contactList = new AddContact().getAll();
        for (Contactad contact : contactList) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
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
        String contact = request.getParameter("btnAddContact");
        String action = request.getParameter("btnAddGroup");
        if (contact != null && contact.equals("AddContact")) {
            String first = request.getParameter("firstname");
            String last = request.getParameter("lastname");
            String phonenumber = request.getParameter("phone");
            Contactad c = new Contactad(first, last, Date.valueOf(LocalDate.now()), phonenumber);
            AddContact ac = new AddContact();
            ac.add(c);
            System.out.println(c.getFirstname());
        }
        if (action != null && action.equals("add")) {
            String name = request.getParameter("name");
            String des = request.getParameter("description");
            FriendGroup group = new FriendGroup(name, des);
            AddGroup ag = new AddGroup();
            ag.add(group);
        } else if (request.getParameter("btnEdit") != null) {
            // Cập nhật một liên hệ đã có
            int id = Integer.parseInt(request.getParameter("ID"));
            Contactad contactToUpdate = getContactById(id);

            if (contactToUpdate != null) {
                // Cập nhật đối tượng liên hệ với các giá trị mới
                contactToUpdate.setFirstname(request.getParameter("firstname"));
                contactToUpdate.setLastname(request.getParameter("lastname"));
                contactToUpdate.setPhoneNumber(request.getParameter("phone"));

                // Thực hiện hoạt động cập nhật
                AddContact ac = new AddContact();
                ac.update(contactToUpdate, id);
            }
        }
        doGet(request, response);
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

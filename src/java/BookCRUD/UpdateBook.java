/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookCRUD;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Denis Ruparel
 */
@WebServlet(name = "UpdateBook", urlPatterns = {"/UpdateBook"})
public class UpdateBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static SessionFactory factory;
    Session s;
    Transaction tx;
    int id;
    String title, catagory, author, price;
    Book b;
    HttpSession hs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        hs = request.getSession(true);
        try {
            factory = new Configuration().configure().buildSessionFactory();
            s = factory.openSession();
            tx = s.beginTransaction();
            id = Integer.parseInt(request.getParameter("bid"));
            title = request.getParameter("bname");
            catagory = request.getParameter("bcatagory");
            author = request.getParameter("bauthor");
            price = request.getParameter("bprice");
            Query q;
            if (!"".equals(title) && !"".equals(catagory) && !"".equals(author) && !"".equals(price)) {
                q = s.createQuery("update Book b set b.bookTitle='" + title + "', b .catagory='" + catagory + "',b.authorName='"+author+"' ,b.price="+ price+" where b.id=" + id);
                q.executeUpdate();
            } 
            if (!"".equals(title)) {
                q = s.createQuery("update Book b set b.bookTitle='" + title + "' where b.id=" + id);
                q.executeUpdate();
            }
            if (!"".equals(catagory)) {
                q = s.createQuery("update Book b set b.catagory='" + catagory + "' where b.id=" + id);
                q.executeUpdate();
            }
            if (!"".equals(author)) {
                q = s.createQuery("update Book b set b.authorName='" + author + "' where b.id=" + id);
                q.executeUpdate();
            }
            if (!"".equals(price)) {
                q = s.createQuery("update Book b set b.price=" + Integer.parseInt(price) + " where b.id=" + id);
                q.executeUpdate();
            }

            tx.commit();
            hs.setAttribute("status", "Book Updated Successfully");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
            hs.setAttribute("status", "Book NOT Updated");
        } finally {
            if (s != null) {
                s.close();
            }
            response.sendRedirect("message.jsp");
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
        processRequest(request, response);
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

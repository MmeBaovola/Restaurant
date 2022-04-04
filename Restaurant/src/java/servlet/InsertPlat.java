/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Commande_detail;
import models.Produit;

public class InsertPlat extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                int idCommande = Integer.valueOf(request.getParameter("idCommande"));
                int idPlat = Integer.valueOf(request.getParameter("idPlat"));
                int quantite = Integer.valueOf(request.getParameter("quantite"));
                int idTable = Integer.valueOf(request.getParameter("idTable"));
                Produit p = new Produit();
                double prix = p.getListeProduit("id = " + idPlat)[0].getPrix();
                Commande_detail commandeDetail = new Commande_detail(0, idCommande, idPlat, quantite, prix, 1);
                commandeDetail.insert();
                RequestDispatcher dp = request.getRequestDispatcher("CommanderPlat?idTable="+idTable);
                dp.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("CommanderPlat");
            }
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

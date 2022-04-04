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
import models.*;

public class CommanderPlat extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                int idTable = 1;
                try {
                    idTable = Integer.valueOf(request.getParameter("idTable"));
                } catch (Exception e) {
                }
                request.setAttribute("idTable", idTable);
                Produit produit = new Produit();
                Commande commande = new Commande();
                LaTable table = new LaTable();
                CommandeView commandeView = new CommandeView();
                LaTable[] listeTable = table.getListeTable("");
                Commande commandeActuelle = commande.getListeCommande("id_table = " + idTable + " AND is_valid = false")[0];
                int idCommande = commandeActuelle.getId();
                request.setAttribute("idCommande", idCommande);
                request.setAttribute("listeTable", listeTable);
                CommandeView[] listeCommandeView = commandeView.getListeCommandeView("id_commande = " + idCommande);
                request.setAttribute("listeCommandeView", listeCommandeView);
                int total = 0;
                for (int i = 0; i < listeCommandeView.length; i++) {
                    total += listeCommandeView[i].getPrix();
                }
                request.setAttribute("total", total);

                Produit[] listeProduit = produit.getListeProduit("");
                request.setAttribute("listeProduit", listeProduit);
                RequestDispatcher disp = request.getRequestDispatcher("insererCommande.jsp");
                disp.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher disp = request.getRequestDispatcher("insererCommande.jsp");
                disp.forward(request, response);
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

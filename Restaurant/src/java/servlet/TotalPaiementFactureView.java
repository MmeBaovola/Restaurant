/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Total_paiement_facture_view;

public class TotalPaiementFactureView extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Total_paiement_facture_view totalPaiementModel = new Total_paiement_facture_view();
            Total_paiement_facture_view[] listePaiement = null;
            try {
                String date1 = request.getParameter("dateMin");
                String date2 = request.getParameter("dateMax");
                if (date1 != null && date2 != null) {
                    try {
                        Date date_1 = Date.valueOf(date1);
                        Date date_2 = Date.valueOf(date2);
                        String type = request.getParameter("type");
                        if (!"".equals(type)) {
                            listePaiement = totalPaiementModel.getListePaiement("date >= '" + date1 + "' AND date <= '" + date2 + "' AND nom_type = '" + type + "'");
                        } else {
                            listePaiement = totalPaiementModel.getListePaiement("date >= '" + date1 + "' AND date <= '" + date2 + "'");
                        }
                    } catch (Exception ex) {
                        String type = request.getParameter("type");
                        if (!"".equals(type)) {
                            listePaiement = totalPaiementModel.getListePaiement("nom_type = '" + type + "'");
                        } else {
                            listePaiement = totalPaiementModel.getListePaiement("");
                        }
                    }
                } else {
                    listePaiement = totalPaiementModel.getListePaiement("");
                }
            } catch (Exception e) {
                listePaiement = totalPaiementModel.getListePaiement("");
            }
            request.setAttribute("listePaiement", listePaiement);
            RequestDispatcher disp = request.getRequestDispatcher("facture.jsp");
            disp.forward(request, response);
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

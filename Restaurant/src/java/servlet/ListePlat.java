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
import models.PrixDeRevient;
import models.Produit;
import models.Type;

public class ListePlat extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                Produit p = new Produit();
                Type t = new Type();
                PrixDeRevient pr = new PrixDeRevient();
                PrixDeRevient[] prixDeRevient = new PrixDeRevient[0];
//                Produit[] produits = new Produit[0];
                if (request.getParameter("idType") != null) {
                    int idType = Integer.valueOf(request.getParameter("idType"));
//                    produits = p.getListeProduit("id_Type = " + idType);
                    prixDeRevient = pr.getListePrixDeRevient("id_type ="+ idType);

                    out.println(idType);
                } else {
//                    produits = p.getListeProduit("");
                    prixDeRevient = pr.getListePrixDeRevient("");

                }
                Type types[] = t.getListeType("");
//                request.setAttribute("produits", produits);
                request.setAttribute("prixDeRevient", prixDeRevient);
                request.setAttribute("types", types);
                RequestDispatcher disp = request.getRequestDispatcher("listePlat.jsp");
                disp.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
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

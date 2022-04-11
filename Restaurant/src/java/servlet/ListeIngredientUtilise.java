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
import models.IngredientUtilise;
import models.Prix_total_ingredient;

public class ListeIngredientUtilise extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String dateMin = "";
            String dateMax = "";
            double prixTotal = 0;
            IngredientUtilise ingredientUtilise = new IngredientUtilise();
            Prix_total_ingredient prixTotalIngredient = new Prix_total_ingredient();
            IngredientUtilise[] listeIngredientUtilise = null;
            try {
                dateMin = request.getParameter("dateMin");
                dateMax = request.getParameter("dateMax");
                prixTotal = prixTotalIngredient.getListePrix_total_ingredient("date >= '" + dateMin + "' AND date <= '" + dateMax + "'")[0].getPrix_total();
                listeIngredientUtilise = ingredientUtilise.getListeIngredientUtilise("date >= '" + dateMin + "' AND date <= '" + dateMax + "'");
            } catch (Exception e) {
                if (dateMin == "" && dateMax == "") {
                    prixTotal = prixTotalIngredient.getListePrix_total_ingredient("")[0].getPrix_total();
                    listeIngredientUtilise = ingredientUtilise.getListeIngredientUtilise("");
                }
                e.printStackTrace();
            } finally {
                request.setAttribute("listeIngredientUtilise", listeIngredientUtilise);
                request.setAttribute("prixTotal", prixTotal);
                RequestDispatcher disp = request.getRequestDispatcher("listeIngredientUtilise.jsp");
                disp.forward(request, response);
            }
            out.println(listeIngredientUtilise.length);

//            RequestDispatcher disp = request.getRequestDispatcher("listeIngredientUtilise.jsp");
//            disp.forward(request, response);
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

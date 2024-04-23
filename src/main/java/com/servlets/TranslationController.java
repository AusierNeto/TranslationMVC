package com.servlets;

import com.classes.FileHandler;
import com.classes.TranslationModel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet(name="TranslationService", urlPatterns={"/Translate"})
@WebServlet("/Translate")
public class TranslationController extends HttpServlet {
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String inputWord = request.getParameter("inputString");
        
        TranslationModel t = new TranslationModel(inputWord);
        
        request.setAttribute("translation", t.getWordTranslation());
        request.getRequestDispatcher("TranslationResponse.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Translation Servlet responsible to get the translations for the input";
    }// </editor-fold>

}

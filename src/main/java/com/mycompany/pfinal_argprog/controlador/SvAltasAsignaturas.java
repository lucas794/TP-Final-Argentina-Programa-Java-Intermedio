/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pfinal_argprog.controlador;

import com.mycompany.pfinal_argprog.modelo.Asignatura;
import com.mycompany.pfinal_argprog.modelo.alertas.*;
import com.mycompany.pfinal_argprog.modelo.validadores.*;
import com.mycompany.pfinal_argprog.persistencia.RecursoAsignaturas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
public class SvAltasAsignaturas extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvAltasAsignaturas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvAltasAsignaturas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setBufferSize(8192 * 16);
        String nombre_asignatura = (String) request.getParameter("asignatura");
        String id = (String) request.getParameter("seleccion_docente");
        
        System.out.println( String.format("== >= %s", id ) );
        System.out.println( String.format("== => %s", nombre_asignatura ) );
        
        ArrayList<IValidadores> validadores = new ArrayList<>();
        
        validadores.add( new ValidadorString( nombre_asignatura ) );
        validadores.add( new ValidadorDocenteYaAsignado(id) );
        
        IAlertas nuevaAlerta;
        HttpSession session = request.getSession();
        
        for( IValidadores v : validadores) {
            if( !v.validar() ){
                nuevaAlerta = new AlertaError( Arrays.asList("", "", "", "", v.obtener_error()) );

                session.setAttribute("alertas_altas_asignaturas", nuevaAlerta );

                //request.getRequestDispatcher("/vista/alta.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath() + "/vista/alta.jsp"); 
                return;
            }
        }
        
        Asignatura asignatura = new Asignatura( nombre_asignatura, Integer.parseInt(id) );
        
        RecursoAsignaturas.crear_asignatura( asignatura );
        
        nuevaAlerta = new AlertaAltaConfirmada( String.format("Se ha dado de alta correctamente la materia %s", nombre_asignatura) ) ;
        
        session.setAttribute("alertas_altas_asignaturas", nuevaAlerta );
        //request.getRequestDispatcher("/vista/alta.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/vista/alta.jsp"); 
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pfinal_argprog.controlador;

import com.mycompany.pfinal_argprog.modelo.validadores.ValidadorIntegers;
import com.mycompany.pfinal_argprog.modelo.validadores.IValidadores;
import com.mycompany.pfinal_argprog.modelo.validadores.ValidadorLegajoExistente;
import com.mycompany.pfinal_argprog.modelo.validadores.ValidadorString;
import com.mycompany.pfinal_argprog.persistencia.RecursoDocentes;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mycompany.pfinal_argprog.modelo.Docente;
import com.mycompany.pfinal_argprog.modelo.alertas.AlertaAltaConfirmada;
import com.mycompany.pfinal_argprog.modelo.alertas.AlertaError;
import com.mycompany.pfinal_argprog.modelo.alertas.IAlertas;

/**
 *
 * @author lucas
 */
public class SvAltasDocentes extends HttpServlet {

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
        //processRequest(request, response);
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
        ArrayList<IValidadores> validadores = new ArrayList<>();
                
        String legajo = (String) request.getParameter("legajo");
        String nombre = (String) request.getParameter("nombre");
        String apellido = (String) request.getParameter("apellido");
        String telefono = (String) request.getParameter("telefono");
        
        validadores.add(new ValidadorIntegers( legajo ));
        validadores.add(new ValidadorString( nombre ));
        validadores.add(new ValidadorString( apellido ));
        validadores.add(new ValidadorString( telefono ));
        validadores.add(new ValidadorLegajoExistente(legajo));
        
        IAlertas nuevaAlerta;
        HttpSession session = request.getSession();
        
        for( IValidadores v : validadores) {
            if ( !v.validar() ){ // si no se pudo validar...     
                
                nuevaAlerta = new AlertaError( Arrays.asList(legajo, nombre, apellido, telefono, v.obtener_error()) );
                
                session.setAttribute("alertas_altas_docentes", nuevaAlerta );
                
                response.sendRedirect(request.getContextPath() + "/vista/alta.jsp");
                //request.getRequestDispatcher("/vista/alta.jsp").forward(request, response);
                return;
            }
        }
        
        // Llegado acá, significa que se validó absolutamente todo!
        Docente tempDocente = new Docente( Integer.valueOf(legajo), nombre, apellido, telefono );
        
        RecursoDocentes.alta_docente(tempDocente);
                
        nuevaAlerta = new AlertaAltaConfirmada( String.format("El legajo %d ha sido registrado en la DB!", Integer.valueOf(legajo)) );
        
        session.setAttribute("alertas_altas_docentes", nuevaAlerta );
        
        response.sendRedirect(request.getContextPath() + "/vista/alta.jsp"); 
        //request.getRequestDispatcher("/vista/alta.jsp").forward(request, response);
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

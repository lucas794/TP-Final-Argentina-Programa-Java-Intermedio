/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.persistencia;

import com.mycompany.pfinal_argprog.modelo.DAO.DocenteDAOImpl;
import com.mycompany.pfinal_argprog.modelo.DAO.IDocentesDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.pfinal_argprog.modelo.Docente;

/**
 *
 * @author lucas
 */
public class RecursoDocentes {
    private static final IDocentesDAO elementoDAO = new DocenteDAOImpl();
    
    public static boolean existe_legajo( int numeroLegajo ) {
        return RecursoDocentes.elementoDAO.existe_legajo(numeroLegajo);
    }
    
    public static void alta_docente( Docente docente ) {
        RecursoDocentes.elementoDAO.alta_docente(docente);
    }
    
    public static void baja_docente( int numeroLegajo ){
        RecursoDocentes.elementoDAO.baja_docente( numeroLegajo );
    }
    
    public static ArrayList<Docente> listar_docentes() {
        return RecursoDocentes.elementoDAO.listar_docentes();
    }
    
    public static String obtenerNombreDocenteCompleto( int id_docente ) {
        return RecursoDocentes.elementoDAO.obtenerNombreDocenteCompleto(id_docente);
    }
}

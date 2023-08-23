/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.persistencia;

import com.mycompany.pfinal_argprog.modelo.Asignatura;
import com.mycompany.pfinal_argprog.modelo.DAO.AsignaturaDAOImpl;
import com.mycompany.pfinal_argprog.modelo.DAO.IAsignaturasDAO;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class RecursoAsignaturas {
    private static final IAsignaturasDAO elementoDAO = new AsignaturaDAOImpl();
    
    public static ArrayList<Asignatura> listar_asignaturas()  {
        return RecursoAsignaturas.elementoDAO.listar_asignaturas();
    }
    
    public static void borrar_asignatura( int id_asignatura ) {
        RecursoAsignaturas.elementoDAO.borrar_asignatura(id_asignatura); 
    }

    public static boolean existe_id_enlazado(int id) {
        return RecursoAsignaturas.elementoDAO.existe_id_enlazado(id);
    }

    public static void crear_asignatura(Asignatura asignatura) {
        RecursoAsignaturas.elementoDAO.crear_asignatura( asignatura );
    }
}

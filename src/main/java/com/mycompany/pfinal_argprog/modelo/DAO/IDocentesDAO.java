/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mycompany.pfinal_argprog.modelo.Docente;

/**
 *
 * @author lucas
 */
public interface IDocentesDAO {
    public boolean existe_legajo( int numeroLegajo );
    public void alta_docente( Docente docente );
    public void baja_docente( int numeroLegajo );
    public ArrayList<Docente> listar_docentes();
    public String obtenerNombreDocenteCompleto( int id_docente );
}

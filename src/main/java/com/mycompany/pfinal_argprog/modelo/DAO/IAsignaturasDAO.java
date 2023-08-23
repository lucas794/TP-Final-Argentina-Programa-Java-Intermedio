/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.DAO;

import com.mycompany.pfinal_argprog.modelo.Asignatura;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface IAsignaturasDAO {
    public ArrayList<Asignatura> listar_asignaturas();

    public void borrar_asignatura(int id_asignatura);

    public boolean existe_id_enlazado(int id);

    public void crear_asignatura(Asignatura asignatura);
}

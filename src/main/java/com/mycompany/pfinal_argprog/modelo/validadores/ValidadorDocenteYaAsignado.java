/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.validadores;

import com.mycompany.pfinal_argprog.persistencia.RecursoAsignaturas;
import com.mycompany.pfinal_argprog.persistencia.RecursoDocentes;

/**
 *
 * @author lucas
 */
public class ValidadorDocenteYaAsignado implements IValidadores {
    private final String idDocente;

    public ValidadorDocenteYaAsignado(String parameter) {
        this.idDocente = parameter;
    }

    @Override
    public boolean validar() {
        // Aquí, la validación es válida si NO se encuentra el valor.
        return !RecursoAsignaturas.existe_id_enlazado(Integer.parseInt(this.idDocente)); 
    }

    @Override
    public String obtener_error() {
        return "ERROR: Este docente YA tiene una materia asignada";
    }
}

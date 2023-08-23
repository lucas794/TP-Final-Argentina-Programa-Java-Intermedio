/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.validadores;

import com.mycompany.pfinal_argprog.persistencia.RecursoDocentes;

/**
 *
 * @author lucas
 */
public class ValidadorLegajoExistente implements IValidadores {

    private final String legajo;

    public ValidadorLegajoExistente(String parameter) {
        this.legajo = parameter;
    }

    @Override
    public boolean validar() {
        // Aquí, la validación es válida si NO se encuentra el valor.
        return !RecursoDocentes.existe_legajo(Integer.parseInt(this.legajo)); 
    }

    @Override
    public String obtener_error() {
        return "ERROR: Este legajo ya está cargado en la DB!";
    }

}

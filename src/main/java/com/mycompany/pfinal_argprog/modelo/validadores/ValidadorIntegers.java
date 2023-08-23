/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lucas
 */
public class ValidadorIntegers implements IValidadores {

    private final String legajo;

    public ValidadorIntegers(String parametro) {
        this.legajo = parametro;
    }

    @Override
    public boolean validar() {
        Pattern pattern = Pattern.compile("^[1-9]+[0-9]*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.legajo);
        return (matcher.find() && this.legajo.length() < 11);
    }

    @Override
    public String obtener_error() {
        return "ERROR: El valor de legajo es inválido";
    }

}

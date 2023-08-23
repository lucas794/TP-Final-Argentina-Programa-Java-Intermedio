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
public class ValidadorString implements IValidadores {

    private final String valor_a_verificar;
    
    public ValidadorString(String str) {
        this.valor_a_verificar = str;
    }
    
    @Override
    public boolean validar() {
        Pattern pattern = Pattern.compile("[a-zA-z-\\d]{1,40}", Pattern.CASE_INSENSITIVE);
        Matcher m1 = pattern.matcher(this.valor_a_verificar);
        return m1.find();
    }

    @Override
    public String obtener_error() {
        return "ERROR: Algun campo está vacio, tiene un valor demasiado largo o tiene formato inválido";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.alertas;

/**
 *
 * @author lucas
 */
public class AlertaDefault implements IAlertas {

    @Override
    public String generarMensajeAlerta() {
        return "";
    }

    @Override
    public String[] obtenerInformacionCampos() {
        return new String[] { "", "", "", "" };
    }
    
}

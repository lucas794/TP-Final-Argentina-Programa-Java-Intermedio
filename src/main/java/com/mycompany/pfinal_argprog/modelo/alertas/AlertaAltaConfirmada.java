/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.alertas;

/**
 *
 * @author lucas
 */
public class AlertaAltaConfirmada implements IAlertas {

    private String mensajeAMostrar;

    public AlertaAltaConfirmada( String str ) {
        this.mensajeAMostrar = str;
    }

    @Override
    public String generarMensajeAlerta() {
        return String.format("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n"
                + "%s\n"
                + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n"
                + "</button>\n"
                + "</div>", this.mensajeAMostrar);
    }

    @Override
    public String[] obtenerInformacionCampos() {
        return new String[] { "", "", "", "" };
    }
}

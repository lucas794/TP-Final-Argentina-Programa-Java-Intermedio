/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.alertas;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author lucas
 */
public class AlertaError implements IAlertas {

    private final String legajo;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String errorGenerado;

    public AlertaError(List<String> listaInformacion) {
        this.legajo = listaInformacion.get(0);
        this.nombre = listaInformacion.get(1);
        this.apellido = listaInformacion.get(2);
        this.telefono = listaInformacion.get(3);
        this.errorGenerado = listaInformacion.get(4);
    }

    @Override
    public String generarMensajeAlerta() {
        return String.format("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n%s"
                + "<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n"
                + "</button>\n"
                + "</div>", this.errorGenerado);
    }

    @Override
    public String[] obtenerInformacionCampos() {
        return new String[]{ this.legajo, this.nombre, this.apellido, this.telefono };
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo;

/**
 *
 * @author lucas
 */
public class Docente {

    private Integer id_docente = null;
    private final Integer legajo;
    private final String nombre;
    private final String apellido;
    private final String telefono;

    public Docente(Integer id_docente, Integer legajo, String nombre, String apellido, String telefono) {
        this.id_docente = id_docente;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    public Docente(Integer legajo, String nombre, String apellido, String telefono) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    public Integer obtenerIDDocente() {
        return id_docente;
    }
    public Integer obtenerLegajo() {
        return legajo;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerTelefono () {
        return telefono;
    }
}

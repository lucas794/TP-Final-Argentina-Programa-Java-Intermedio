/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo;

/**
 *
 * @author lucas
 */
public class Asignatura {

    private Integer id_materia = null;
    private final String nombre_materia;
    private final Integer id_referencia_docente;
    private String nombre_docente = null;

    public Asignatura(Integer id_materia, String nombre_materia, Integer id_referencia_docente, String nombre_docente) {
        this.id_materia = id_materia;
        this.nombre_materia = nombre_materia;
        this.id_referencia_docente = id_referencia_docente;
        this.nombre_docente = nombre_docente;
    }

    public Asignatura(String nombre_asignatura, int id_docente) {
        this.nombre_materia = nombre_asignatura;
        this.id_referencia_docente = id_docente;
    }

    public String obtenerNombreDelDocente() {
        return nombre_docente;
    }
    
    public Integer obtenerIDMateria() {
        return id_materia;
    }

    public String obtenerNombreMateria() {
        return nombre_materia;
    }

    public Integer obtenerIDReferenciaDocente() {
        return id_referencia_docente;
    }
    
}

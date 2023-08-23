/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class ConexionDB {

    private final String url = "jdbc:mysql://localhost:3306/bdfinal";
    private Connection conn = null;

    private static ConexionDB connectionFactory = null;

    private ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection obtenerConexion() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(this.url, "root", "");
        return conn;
    }

    public static ConexionDB obtenerInstancia() {
        if (connectionFactory == null) {
            connectionFactory = new ConexionDB();
        }
        return connectionFactory;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.DAO;

import com.mycompany.pfinal_argprog.persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mycompany.pfinal_argprog.modelo.Docente;

/**
 *
 * @author lucas
 */
public class DocenteDAOImpl implements IDocentesDAO {

    private Connection conn = null;

    @Override
    public String obtenerNombreDocenteCompleto( int id_profesor ) {
        String nombre = null;
        String apellido = null;

        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (PreparedStatement stmt = conn.prepareStatement(String.format("SELECT nombre, apellido FROM profesor WHERE id_profesor=%d;", id_profesor))) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        nombre = rs.getString("nombre");
                        apellido = rs.getString("apellido");
                    }
                    rs.close();
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception:" + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception:" + e.getMessage());
            }
        }
        return String.format("%s %s", nombre, apellido);
    }

    @Override
    public boolean existe_legajo(int numeroLegajo) {
        boolean encontrado = false;

        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (PreparedStatement stmt = this.conn.prepareStatement(String.format("SELECT * FROM profesor WHERE legajo=%d", numeroLegajo))) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        encontrado = true;
                    }
                    rs.close();
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception:" + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception:" + e.getMessage());
            }
        }
        return encontrado;
    }

    @Override
    public void alta_docente(Docente docente) {
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            Statement stmt = this.conn.createStatement();
            // Execute a query

            stmt.executeUpdate(
                    String.format("INSERT INTO `profesor` (`legajo`, `nombre`, `apellido`, `telefono`) VALUES ('%d', '%s', '%s', '%s');",
                            docente.obtenerLegajo(), docente.obtenerNombre(), docente.obtenerApellido(), docente.obtenerTelefono())
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void baja_docente(int numeroLegajo) {
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (Statement stmt = this.conn.createStatement()) {
                stmt.executeUpdate(String.format("DELETE FROM profesor WHERE id_profesor=%d", numeroLegajo));
                this.reiniciar_auto_increment();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Docente> listar_docentes() {
        ArrayList<Docente> tmp = new ArrayList<>();
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM profesor")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Docente temporal = new Docente(rs.getInt("id_profesor"), rs.getInt("legajo"),
                                rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"));
                        tmp.add(temporal);
                    }
                    rs.close();
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception:" + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception:" + e.getMessage());
            }
        }
        return tmp;
    }

    private void reiniciar_auto_increment() {
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            Statement stmt = this.conn.createStatement();
            // Execute a query

            stmt.executeUpdate("SET  @num := 0;");
            stmt.executeUpdate("UPDATE profesor SET id_profesor = @num := (@num+1);");
            stmt.executeUpdate("ALTER TABLE profesor AUTO_INCREMENT =1;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

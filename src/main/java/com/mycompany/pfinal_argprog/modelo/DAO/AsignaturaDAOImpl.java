/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pfinal_argprog.modelo.DAO;

import com.mycompany.pfinal_argprog.modelo.Asignatura;
import com.mycompany.pfinal_argprog.persistencia.ConexionDB;
import com.mycompany.pfinal_argprog.persistencia.RecursoDocentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class AsignaturaDAOImpl implements IAsignaturasDAO {
    
    private Connection conn = null;
    
    @Override
    public ArrayList<Asignatura> listar_asignaturas() {
        ArrayList<Asignatura> tmp = new ArrayList<>();
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM asignatura")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String nombreDocente = RecursoDocentes.obtenerNombreDocenteCompleto( rs.getInt("referencia_iddocente"));
                                
                        Asignatura temporal = new Asignatura( rs.getInt("id_asignatura"), rs.getString("nombre"),
                                rs.getInt("referencia_iddocente"), nombreDocente );
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

    @Override
    public void borrar_asignatura(int id_asignatura) {
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (Statement stmt = this.conn.createStatement()) {
                stmt.executeUpdate(String.format("DELETE FROM asignatura WHERE id_asignatura=%d", id_asignatura));
                this.reiniciar_auto_increment();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void reiniciar_auto_increment() {
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            Statement stmt = this.conn.createStatement();
            // Execute a query

            stmt.executeUpdate("SET  @num := 0;");
            stmt.executeUpdate("UPDATE asignatura SET id_asignatura = @num := (@num+1);");
            stmt.executeUpdate("ALTER TABLE asignatura AUTO_INCREMENT =1;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existe_id_enlazado(int id) {
        boolean encontrado = false;

        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            try (PreparedStatement stmt = this.conn.prepareStatement(String.format("SELECT * FROM `asignatura` WHERE referencia_iddocente=%d;", id))) {
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
    public void crear_asignatura(Asignatura asignatura) {
        try {
            this.conn = ConexionDB.obtenerInstancia().obtenerConexion();
            Statement stmt = this.conn.createStatement();
            // Execute a query

            stmt.executeUpdate(
                    String.format("INSERT INTO `asignatura` (`nombre`, `referencia_iddocente`) VALUES ('%s', '%d');",
                            asignatura.obtenerNombreMateria(), asignatura.obtenerIDReferenciaDocente())
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

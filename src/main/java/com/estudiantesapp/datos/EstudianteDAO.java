package com.estudiantesapp.datos;

import com.estudiantesapp.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.estudiantesapp.conexion.Conexion.getConexion;

public class EstudianteDAO {
    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                estudiantes.add(estudiante);
            }
        } catch(Exception ex) {
            System.out.println("Ocurrió un error al seleccionar datos: " +ex.getMessage());
        } finally {
            try {
                con.close();
            } catch(Exception ex) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return estudiantes;
    }

    public boolean buscarPorId(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.idEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        } catch(Exception ex) {
            System.out.println("Ocurrió un error al buscar datos: " +ex.getMessage());
        } finally {
            try {
                con.close();
            } catch(Exception ex) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean agregar(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email) VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.nombre());
            ps.setString(2, estudiante.apellido());
            ps.setString(3, estudiante.telefono());
            ps.setString(4, estudiante.email());
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error al agregar el estudiante: " + ex.getMessage());
        } finally {
            try {
                con.close();
            } catch(Exception ex) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean actualizar(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre=?, apellido=?, telefono=?, email=? WHERE id_estudiante=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.nombre());
            ps.setString(2, estudiante.apellido());
            ps.setString(3, estudiante.telefono());
            ps.setString(4, estudiante.email());
            ps.setInt(5, estudiante.idEstudiante());
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error al actualizar el estudiante: " + ex.getMessage());
        } finally {
            try {
                con.close();
            } catch(Exception ex) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean eliminar(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.idEstudiante());
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar el estudiante: " + ex.getMessage());
        } finally {
            try {
                con.close();
            } catch(Exception ex) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return false;
    }
}

package com.estudiantesapp.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;

        var BD = "estudiantes_db";
        var url = "jdbc:mysql://localhost:3306/" + BD;
        var user = "root";
        var pass = "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("Ocurrió un error en la conexión " +ex.getMessage());
        }

        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion != null) {
            System.out.println("Conexión exitosa: " + conexion);
        } else {
            System.out.println("Error al conectarse");
        }
    }
}

package com.sena.aprendiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de establecer la conexión
 * entre la aplicación y la base de datos MySQL.
 */
public class Conexion {

    // URL de conexión a la base de datos.
    private static final String URL =
            "jdbc:mysql://localhost:3306/aprendizweb";

    // Usuario utilizado para conectarse a MySQL.
    private static final String USER = "root";

    // Contraseña del usuario de MySQL.
    // Se recomienda no publicar credenciales reales en GitHub.
    private static final String PASSWORD = "BrandonBecerra1545$";

    /**
     * Establece y devuelve una conexión con MySQL.
     *
     * @return conexión activa o null si ocurre un error.
     */
    public static Connection getConexion() {

        Connection con = null;

        try {

            // Carga el controlador JDBC de MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión con la base de datos.
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexión exitosa a MySQL");

        } catch (ClassNotFoundException | SQLException e) {

            // Muestra información si ocurre un error de conexión.
            e.printStackTrace();
        }

        return con;
    }
}
package com.sena.aprendiz.dao;

import com.sena.aprendiz.model.Aprendiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase DAO encargada de realizar las operaciones
 * relacionadas con la entidad Aprendiz en la base de datos.
 */
public class AprendizDAO {

    /**
     * Guarda un nuevo aprendiz en la base de datos.
     *
     * @param aprendiz objeto que contiene los datos del aprendiz
     * @return true si el registro fue guardado correctamente,
     *         false si ocurre algún error
     */
    public boolean guardar(Aprendiz aprendiz) {

        // Sentencia SQL utilizada para insertar el aprendiz.
        String sql = "INSERT INTO aprendiz(nombre, apellido, correo, telefono) "
                   + "VALUES (?, ?, ?, ?)";

        /*
         * Try-with-resources:
         * cierra automáticamente la conexión y el PreparedStatement
         * cuando termina la operación.
         */
        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            // Asigna los datos del aprendiz a los parámetros de la consulta.
            ps.setString(1, aprendiz.getNombre());
            ps.setString(2, aprendiz.getApellido());
            ps.setString(3, aprendiz.getCorreo());
            ps.setString(4, aprendiz.getTelefono());

            // Ejecuta la sentencia INSERT.
            ps.executeUpdate();

            // Indica que el registro fue realizado correctamente.
            return true;

        } catch (SQLException e) {

            // Muestra información del error ocurrido en la base de datos.
            e.printStackTrace();

            // Indica que el registro no pudo realizarse.
            return false;
        }
    }
}
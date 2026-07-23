package com.sena.aprendiz.dao;

import com.sena.aprendiz.model.Aprendiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AprendizDAO {

    public boolean guardar(Aprendiz aprendiz) {

        String sql = "INSERT INTO aprendiz(nombre, apellido, correo, telefono) VALUES (?, ?, ?, ?)";

        try {

            Connection con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, aprendiz.getNombre());
            ps.setString(2, aprendiz.getApellido());
            ps.setString(3, aprendiz.getCorreo());
            ps.setString(4, aprendiz.getTelefono());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }

    }

}
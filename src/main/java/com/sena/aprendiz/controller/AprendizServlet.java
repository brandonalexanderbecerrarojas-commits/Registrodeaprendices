package com.sena.aprendiz.controller;

import com.sena.aprendiz.dao.AprendizDAO;
import com.sena.aprendiz.model.Aprendiz;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrar")
public class AprendizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        Aprendiz aprendiz = new Aprendiz();

        aprendiz.setNombre(nombre);
        aprendiz.setApellido(apellido);
        aprendiz.setCorreo(correo);
        aprendiz.setTelefono(telefono);

        AprendizDAO dao = new AprendizDAO();

        if (dao.guardar(aprendiz)) {
            response.sendRedirect("index.jsp?mensaje=ok");
        } else {
            response.sendRedirect("index.jsp?mensaje=error");
        }

    }
}
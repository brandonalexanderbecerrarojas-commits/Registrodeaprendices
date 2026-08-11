package com.sena.aprendiz.controller;

import com.sena.aprendiz.dao.AprendizDAO;
import com.sena.aprendiz.model.Aprendiz;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de gestionar el registro de aprendices.
 * Recibe las solicitudes provenientes del formulario web
 * y procesa la información para almacenarla en la base de datos.
 */
@WebServlet("/registrar")
public class AprendizServlet extends HttpServlet {

    /**
     * Método GET utilizado para comprobar que el Servlet
     * está disponible y responde correctamente.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println(
                "<h1>El método GET funciona correctamente</h1>"
        );
    }

    /**
     * Método POST encargado de recibir los datos enviados
     * desde el formulario de registro de aprendices.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene los datos enviados desde el formulario HTML/JSP.
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        // Crea un nuevo objeto Aprendiz.
        Aprendiz aprendiz = new Aprendiz();

        // Asigna al objeto los datos recibidos del formulario.
        aprendiz.setNombre(nombre);
        aprendiz.setApellido(apellido);
        aprendiz.setCorreo(correo);
        aprendiz.setTelefono(telefono);

        // Crea el objeto DAO encargado de comunicarse con la base de datos.
        AprendizDAO dao = new AprendizDAO();

        // Intenta guardar el aprendiz en la base de datos.
        if (dao.guardar(aprendiz)) {

            // Si el registro fue exitoso, regresa al formulario
            // mostrando el mensaje correspondiente.
            response.sendRedirect("index.jsp?mensaje=ok");

        } else {

            // Si ocurre un error, regresa al formulario
            // indicando que el registro no pudo realizarse.
            response.sendRedirect("index.jsp?mensaje=error");
        }
    }
}
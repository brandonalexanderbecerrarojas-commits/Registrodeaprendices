package com.sena.aprendiz.dao;

import com.sena.aprendiz.model.Aprendiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas unitarias para la clase AprendizDAO.
 */
public class AprendizDAOTest {

    /**
     * Comprueba que el DAO pueda guardar correctamente
     * un aprendiz en la base de datos.
     */
    @Test
    void deberiaGuardarAprendiz() {

        Aprendiz aprendiz = new Aprendiz();

        aprendiz.setNombre("Prueba");
        aprendiz.setApellido("Unitario");
        aprendiz.setCorreo("prueba@correo.com");
        aprendiz.setTelefono("3000000000");

        AprendizDAO dao = new AprendizDAO();

        boolean resultado = dao.guardar(aprendiz);

        assertTrue(resultado);
    }
}
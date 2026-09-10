package com.sena.aprendiz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para la clase Aprendiz.
 */
public class AprendizTest {

    @Test
    void deberiaGuardarYObtenerNombre() {

        Aprendiz aprendiz = new Aprendiz();

        aprendiz.setNombre("Brandon");

        assertEquals("Brandon", aprendiz.getNombre());
    }

    @Test
    void deberiaGuardarYObtenerApellido() {

        Aprendiz aprendiz = new Aprendiz();

        aprendiz.setApellido("Becerra");

        assertEquals("Becerra", aprendiz.getApellido());
    }

    @Test
    void deberiaGuardarYObtenerCorreo() {

        Aprendiz aprendiz = new Aprendiz();

        aprendiz.setCorreo("brandon@gmail.com");

        assertEquals("brandon@gmail.com", aprendiz.getCorreo());
    }

    @Test
    void deberiaGuardarYObtenerTelefono() {

        Aprendiz aprendiz = new Aprendiz();

        aprendiz.setTelefono("3001234567");

        assertEquals("3001234567", aprendiz.getTelefono());
    }
}
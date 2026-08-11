package com.sena.aprendiz.model;

/**
 * Clase modelo que representa la información
 * de un aprendiz dentro de la aplicación.
 */
public class Aprendiz {

    // Datos básicos del aprendiz.
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    /**
     * Constructor vacío utilizado para crear
     * objetos de tipo Aprendiz.
     */
    public Aprendiz() {
    }

    /**
     * Obtiene el nombre del aprendiz.
     *
     * @return nombre del aprendiz
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del aprendiz.
     *
     * @param nombre nombre del aprendiz
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del aprendiz.
     *
     * @return apellido del aprendiz
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del aprendiz.
     *
     * @param apellido apellido del aprendiz
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico del aprendiz.
     *
     * @return correo del aprendiz
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del aprendiz.
     *
     * @param correo correo del aprendiz
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número telefónico del aprendiz.
     *
     * @return teléfono del aprendiz
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número telefónico del aprendiz.
     *
     * @param telefono teléfono del aprendiz
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
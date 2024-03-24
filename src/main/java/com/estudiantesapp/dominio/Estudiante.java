package com.estudiantesapp.dominio;

public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Estudiante() {

    }

    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public Estudiante(int idEstudiante, String nombre, String apellido, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public int idEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String apellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String telefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre=" + nombre +
                ", apellido=" + apellido +
                ", telefono=" + telefono +
                ", email=" + email +
                '}';
    }
}

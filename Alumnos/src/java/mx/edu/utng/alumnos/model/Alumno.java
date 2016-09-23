/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.alumnos.model;

/**
 *
 * @author volibear
 */
public class Alumno {
   private int idAlumno;
   private String nombre;
   private int edad;
   private int numeroControl;
   private String genero ;
   private String grupo;

    public Alumno(int idAlumno, String nombre, int edad, int numeroControl, String genero, String grupo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.edad = edad;
        this.numeroControl = numeroControl;
        this.genero = genero;
        this.grupo = grupo;
    }

    public Alumno() {
        this(0, "", 0, 0, "", "");
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(int numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", edad=" + edad + ", numeroControl=" + numeroControl + ", genero=" + genero + ", grupo=" + grupo + '}';
    }
    
    
    

   
    

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.alumnos.dao;

import java.util.List;
import mx.edu.utng.alumnos.model.Alumno;

/**
 *
 * @author volibear
 */
public interface AlumnoDAO {
    void agregarAlumno(Alumno alumno);
    void borrarAlumno(int idAlumno);
    void cambiarAlumno(Alumno alumno);
    List<Alumno> desplegarAlumnos();
    Alumno elegirAlumno(int idAlumno);

}

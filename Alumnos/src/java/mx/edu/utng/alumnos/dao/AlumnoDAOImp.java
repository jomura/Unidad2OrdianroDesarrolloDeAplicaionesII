/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.alumnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.alumnos.model.Alumno;
import mx.edu.utng.alumnos.util.UtilDB;

/**
 *
 * @author volibear
 */
public class AlumnoDAOImp implements AlumnoDAO{

    private Connection connection;
    
    public AlumnoDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarAlumno(Alumno alumno) {
        try {
          String query = "INSERT INTO alumnos (nombre, edad, "
                  + " numero_control, genero, grupo) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getEdad());
            ps.setInt(3, alumno.getNumeroControl());
            ps.setString(4, alumno.getGenero());
            ps.setString(5, alumno.getGrupo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarAlumno(int idAlumno) {
        try {
             String query = "DELETE FROM alumnos WHERE id_alumno = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idAlumno);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarAlumno(Alumno alumno) {
    try {
          String query = "UPDATE alumnos SET nombre = ?, "
                  + " edad= ?, numero_control=?, genero=?, grupo=? WHERE "
                  + " id_alumno = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getEdad());
            ps.setInt(3, alumno.getNumeroControl());
            ps.setString(4, alumno.getGenero());
            ps.setString(5, alumno.getGrupo());
            ps.setInt(6, alumno.getIdAlumno());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Alumno> desplegarAlumnos() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM alumnos");
            while (resultSet.next()) {
              Alumno alumno = new Alumno(
              
              resultSet.getInt("id_alumno"),
              resultSet.getString("nombre"),
              resultSet.getInt("edad"),
              resultSet.getInt("numero_control"),
              resultSet.getString("genero"),
              resultSet.getString("grupo"));
              alumnos.add(alumno);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alumnos;
    }

    @Override
    public Alumno elegirAlumno(int idAlumno) {
       Alumno alumno = new Alumno();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM alumnos WHERE "
                                + " id_alumno = ?");
        statement.setInt(1, idAlumno);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              alumno.setIdAlumno(
                      resultSet.getInt("id_alumno"));
              alumno.setNombre(
                      resultSet.getString("nombre"));
              alumno.setEdad(
                      resultSet.getInt("edad"));
              alumno.setNumeroControl(
                      resultSet.getInt("numero_control"));
              alumno.setGenero(
                      resultSet.getString("genero"));
              alumno.setGrupo(
                      resultSet.getString("grupo"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return alumno;
    }
    
    
}

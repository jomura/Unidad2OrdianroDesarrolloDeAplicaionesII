<%-- 
    Document   : lista_alumnos
    Created on : 20/09/2016, 12:24:13 PM
    Author     : Volibear
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alumnos</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Id de alumno</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>NumeroControl</th>
                <th>Gener</th>
                <th>Grupo</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="alumno" 
                           items="${alumnos}">
                    <tr>
                        <td>${alumno.idAlumno}</td>
                        <td>${alumno.nombre}</td>
                        <td>${alumno.edad}</td>
                        <td>${alumno.numeroControl}</td>
                        <td>${alumno.genero}</td>
                        <td>${alumno.grupo}</td>
                        <td><a href="AlumnoController?action=cambiar&idAlumno=${alumno.idAlumno}">Cambiar</a></td>
                        <td><a href="AlumnoController?action=borrar&idAlumno=${alumno.idAlumno}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="AlumnoController?action=agregar">
                Agregar alumno
            </a>
        </p>
    </body>
</html>

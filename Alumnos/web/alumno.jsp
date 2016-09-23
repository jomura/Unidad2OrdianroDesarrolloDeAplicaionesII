<%-- 
    Document   : alumno
    Created on : 20/09/2016, 12:24:45 PM
    Author     : Volibear
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>
        <form action="AlumnoController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="idAlumno">Id Alumno:</label>
                <input type="text" name="idAlumno"
                       value="${alumno.idAlumno}"
                       readonly="readonly" 
                       placeholder="Id del alumno"/>
                </div>
                
                <div>
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre"
                       value="${alumno.nombre}"
                       placeholder="Nombre del alumno"/>
                </div>
                 
                <div>
                <label for="edad">Edad:</label>
                <input type="text" name="edad"
                       value="${alumno.edad}"
                       placeholder="Edad del Alumno"/>
                </div>
                
                <div>
                <label for="numeroControl">NumeroControl:</label>
                <input type="text" name="numeroControl"
                       value="${alumno.numeroControl}"
                       placeholder="Numero de control"/>
                </div>
                       
                <div>
                <label for="genero">Genero:</label>
                <input type="text" name="genero"
                       value="${alumno.genero}"
                       placeholder="Genero"/>
                </div>
                
                <div>
                <label for="grupo">Grupo:</label>
                <input type="text" name="grupo"
                       value="${alumno.grupo}"
                       placeholder="Grupo"/>
                </div>
                       
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>

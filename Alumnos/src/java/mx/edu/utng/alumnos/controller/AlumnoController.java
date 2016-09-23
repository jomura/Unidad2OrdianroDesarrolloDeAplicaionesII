package mx.edu.utng.alumnos.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.alumnos.dao.AlumnoDAOImp;
import mx.edu.utng.alumnos.model.Alumno;
import mx.edu.utng.alumnos.dao.AlumnoDAO;
public class AlumnoController extends HttpServlet {
   private static final String
           LISTA_ALUMNOS = "/lista_alumnos.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "alumno.jsp";
   private AlumnoDAO dao;
   
   public AlumnoController(){
       dao = new AlumnoDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_ALUMNOS;
            int idAlumno = Integer.parseInt(
                request.getParameter("idAlumno"));
            dao.borrarAlumno(idAlumno);
            request.setAttribute("alumnos",
                    dao.desplegarAlumnos());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idAlumno = Integer.parseInt(
                request.getParameter("idAlumno"));
             Alumno alumno = 
                     dao.elegirAlumno(idAlumno);
             request.setAttribute("alumno", alumno);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_ALUMNOS;
             request.setAttribute("alumnos", 
                     dao.desplegarAlumnos());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Alumno alumno = new Alumno();
        alumno.setNombre(request.getParameter("nombre"));
        alumno.setEdad(Integer.parseInt(
                request.getParameter("edad")));
        alumno.setNumeroControl(Integer.parseInt(
                request.getParameter("numeroControl")));
        alumno.setGenero(request.getParameter("genero"));
        alumno.setGrupo(request.getParameter("grupo"));
        String idAlumno = request.getParameter("idAlumno");
        
        if(idAlumno==null|| idAlumno.isEmpty()||idAlumno.trim().equals("")){
            dao.agregarAlumno(alumno);
        }else{
            alumno.setIdAlumno(
                    Integer.parseInt(idAlumno));
            dao.cambiarAlumno(alumno);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_ALUMNOS);
        request.setAttribute("alumnos", 
                dao.desplegarAlumnos());
        view.forward(request, response);
    }
}

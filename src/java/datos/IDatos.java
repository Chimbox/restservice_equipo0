package datos;

import entities.Alumno;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
public interface IDatos {
    public Alumno guardarAlumno(Alumno alumno);
    public void eliminarAlumno(int id);
    public List<Alumno> consultarAlumnos();
    public Alumno consultarAlumno(int id);
    public Alumno consultarAlumno(String matricula);
}

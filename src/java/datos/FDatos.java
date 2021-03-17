package datos;

import entities.Alumno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class FDatos implements IDatos{

    private static EntityManager em;
    private static AlumnoRepository alumnoRep;

    public FDatos(EntityManager em) {
        FDatos.em = em;
    }

    private static AlumnoRepository getAlumnoRep() {
        if(alumnoRep==null){
            alumnoRep=new AlumnoRepository(em, Alumno.class);
        }
        return alumnoRep;
    }
    
    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return getAlumnoRep().save(alumno);
    }

    @Override
    public void eliminarAlumno(int id) {
        getAlumnoRep().delete(id);
    }

    @Override
    public List<Alumno> consultarAlumnos() {
        return getAlumnoRep().findAll();
    }

    @Override
    public Alumno consultarAlumno(int id) {
        return getAlumnoRep().find(id);
    }
    
    @Override
    public Alumno consultarAlumno(String matricula){
        return getAlumnoRep().find(matricula);
    }
}

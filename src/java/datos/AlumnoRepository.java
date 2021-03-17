package datos;

import entities.Alumno;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class AlumnoRepository extends RepositoryBase<Alumno>{
    
    public AlumnoRepository(EntityManager entityManager, Class<Alumno> cls) {
        super(entityManager, cls);
    }
    
    
    public Alumno find(String matricula) {
        Alumno alumno =(Alumno) this.entityManager.createQuery("SELECT p FROM " + cls.getName() + " p WHERE p.matricula=:matricula")
                .setParameter("matricula", matricula)
                .getSingleResult();
        return alumno;
    }
}

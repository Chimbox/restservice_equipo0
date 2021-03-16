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
    
}

package datos;

import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class FDatos implements IDatos{

    private EntityManager em;

    public FDatos(EntityManager em) {
        this.em = em;
    }
    
    
    
}

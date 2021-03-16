package datos;

import entities.EntityBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

abstract class RepositoryBase<T extends EntityBase> implements Repository<T> {

    protected final EntityManager entityManager;
    protected final Class<T> cls;

    protected RepositoryBase(EntityManager entityManager, Class<T> cls) {
        this.entityManager = entityManager;
        this.cls = cls;
    }
    
    @Override
    public T find(int id) {
        T entity = this.entityManager.find(cls, id);
        return entity;
    }
    
    @Override
    public List<T> findAll(){
        List lst= this.entityManager.createQuery("SELECT p FROM "+cls.getName()+" p").getResultList();
        
        
        System.out.println(lst.size());
        return lst;
    }

    @Override
    public T save(T entity) {
        this.ensureTransaction();
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
            return entity;
        } else {
            return this.entityManager.merge(entity);
        }
    }

    @Override
    public void delete(T entity) {
        this.ensureTransaction();
        this.entityManager.remove(entity);
    }

    @Override
    public void commit() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }
    
    protected void ensureTransaction() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }
}

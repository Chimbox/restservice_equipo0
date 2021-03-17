package datos;

import entities.EntityBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;

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
    public List<T> findAll() {
        List lst = this.entityManager.createQuery("SELECT p FROM " + cls.getName() + " p").getResultList();
        System.out.println(lst.size());
        return lst;
    }

    @Override
    public T save(T entity) {
        this.ensureTransaction();
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
            commit();
            return entity;
        } else {
            T obj = this.entityManager.merge(entity);
            commit();
            return obj;
        }

    }

    @Override
    public void delete(int id) {
        this.ensureTransaction();
        int isSuccessful = entityManager.createQuery("delete from Alumno p where p.id=:id")
                .setParameter("id", id)
                .executeUpdate();
        commit();
        if (isSuccessful == 0) {
            throw new OptimisticLockException("Ocurrió un error al eliminar.");
        }
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

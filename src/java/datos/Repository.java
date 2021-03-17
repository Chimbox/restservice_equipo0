package datos;

import entities.EntityBase;
import java.util.List;

interface Repository<T extends EntityBase> {
    T find(int id);
    List<T> findAll();
    T save(T entity);
    void delete(int id);
    void commit();
}

package es.upm.miw.apaw.ecp2.api.daos;

import java.util.List;

public interface GenericDao<T, I> {

    void create(T entity);

    T read(I id);

    void update(T entity);

    void deleteById(I id);

    List<T> findAll();

}

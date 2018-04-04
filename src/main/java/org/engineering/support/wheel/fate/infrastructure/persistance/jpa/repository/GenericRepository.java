package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository;

/**
 * Created by umer on 4/3/2018.
 */
public interface GenericRepository<K, E> {

    void detach(E entity) throws Exception;

    E findById(K id) throws Exception;

    E findLockedEntityById(K id) throws Exception;

    void persist(E entity) throws Exception;

    E merge(E entity) throws Exception;

    void flush() throws Exception;

    void remove(E entity) throws Exception;

    void refresh(E entity) throws Exception;

    void refreshLockedEntity(E entity) throws Exception;

    void lock(E entity) throws Exception;

}
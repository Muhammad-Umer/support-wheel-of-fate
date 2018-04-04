package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by umer on 4/3/2018.
 */
@Repository
public abstract class GenericRepositoryImpl<K, E> implements GenericRepository<K, E> {

    private static final Logger LOG = LoggerFactory.getLogger(GenericRepositoryImpl.class);

    @PersistenceContext(unitName = "generalPersistenceUnit")
    protected EntityManager entityManager;

    private Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public GenericRepositoryImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    public void start() throws Exception {
        try {
            entityManager
                    .getTransaction()
                    .begin();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void commit() throws Exception {
        try {
            entityManager
                    .getTransaction()
                    .commit();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void detach(E entity) throws Exception {
        try {
            entityManager.detach(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public E findById(K id) throws Exception {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    @Override
    public E findLockedEntityById(K id) throws Exception {
        try {
            return entityManager.find(entityClass, id, LockModeType.OPTIMISTIC);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void persist(E entity) throws Exception {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public E merge(E entity) throws Exception {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void flush() throws Exception {
        try {
            entityManager.flush();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void remove(E entity) throws Exception {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void refresh(E entity) throws Exception {
        try {
            entityManager.refresh(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void refreshLockedEntity(E entity) throws Exception {
        try {
            entityManager.refresh(entity, LockModeType.OPTIMISTIC);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void lock(E entity) throws Exception {
        try {
            entityManager.lock(entity, LockModeType.OPTIMISTIC);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

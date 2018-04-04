package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.common.GenericEntity;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.MainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by umer on 4/3/2018.
 */
@Repository
public abstract class MainRepositoryImpl<E extends GenericEntity<Integer>> extends GenericRepositoryImpl<Integer, E>
        implements MainRepository<E> {

    private static final Logger LOG = LoggerFactory.getLogger(MainRepositoryImpl.class);

    @Override
    public E save(E entity) throws Exception {
        entity = saveWithoutFlush(entity);
        flush();
        return entity;
    }

    @Override
    public E saveWithoutFlush(E entity) throws Exception {
        if (entity.getId() != null) {
            return merge(entity);
        } else {
            persist(entity);
            return entity;
        }
    }

    public E typedQueryResult(TypedQuery<E> query) {
        query.setFirstResult(0);
        query.setMaxResults(1);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            LOG.error("", e);
            return null;
        }
    }

}

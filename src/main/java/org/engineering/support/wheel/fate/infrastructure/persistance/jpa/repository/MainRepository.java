package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.common.GenericEntity;

import javax.persistence.TypedQuery;
/**
 * Created by umer on 4/3/2018.
 */
public interface MainRepository<E extends GenericEntity<Integer>> extends GenericRepository<Integer, E> {
    E save(E entity) throws Exception;

    E saveWithoutFlush(E entity) throws Exception;

    E typedQueryResult(TypedQuery<E> query);
}
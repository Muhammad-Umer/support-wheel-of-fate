package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.EngineerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Repository
public class EngineerRepositoryImpl extends MainRepositoryImpl<Engineer> implements EngineerRepository {

    @Override
    public List<Engineer> getEngineers(Integer limit) {
        TypedQuery<Engineer> query = entityManager.createNamedQuery("getEngineers", Engineer.class);
        query.setFirstResult(0);
        query.setMaxResults(limit);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}

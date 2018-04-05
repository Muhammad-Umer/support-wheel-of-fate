package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.ShiftRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Repository
public class ShiftRepositoryImpl extends MainRepositoryImpl<Shift> implements ShiftRepository {

    @Override
    public List<Shift> getShiftsOfSchedule(Date date, Integer limit) {
        TypedQuery<Shift> query = entityManager.createNamedQuery("getShiftsOfSchedule", Shift.class);
        query.setParameter("shiftDate", date);
        query.setFirstResult(0);
        query.setMaxResults(limit);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}

package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.ShiftRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
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

    @Override
    public Shift getShiftsByDate(Date date) {
        TypedQuery<Shift> query = entityManager.createNamedQuery("getShiftsByDate", Shift.class);
        query.setParameter("shiftDate", date);
        query.setFirstResult(0);
        query.setMaxResults(1);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Integer deleteSchedule(Date date, Integer limit) {
        String deleteScheduleQuery = "DELETE FROM shift WHERE shift_date > :date ORDER BY id ASC LIMIT :limit";

        Query query = entityManager.createNativeQuery(deleteScheduleQuery, Shift.class);
        query.setParameter("date", date);
        query.setParameter("limit", limit);

        try {
            return query.executeUpdate();
        } catch (Exception e) {
            return null;
        }
    }
}

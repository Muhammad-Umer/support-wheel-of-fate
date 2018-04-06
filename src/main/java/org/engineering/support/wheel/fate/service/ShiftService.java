package org.engineering.support.wheel.fate.service;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.sql.Date;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
public interface ShiftService {
    void storeShifts(List<Shift> shifts) throws Exception;
    List<Shift> getShiftsOfSchedule(Date date, Integer limit);
    Shift getShiftsByDate(Date date);
    Integer deleteSchedule(Date date, Integer limit);
}

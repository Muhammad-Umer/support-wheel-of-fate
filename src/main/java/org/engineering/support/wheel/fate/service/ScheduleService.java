package org.engineering.support.wheel.fate.service;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
public interface ScheduleService {
    boolean generateSchedule(Integer numberOfEngineers, Integer numberOfShifts, List<Shift> shifts) throws Exception;
    List<Shift> getSchedule(Date date, Integer numberOfShifts);
}

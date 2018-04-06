package org.engineering.support.wheel.fate.interfaces.facade;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.sql.Date;

/**
 * Created by umer on 4/7/2018.
 */
public interface ShiftFacade {
    Shift getShiftsByDate(Date date);
}

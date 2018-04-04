package org.engineering.support.wheel.fate.interfaces.facade;

import org.engineering.support.wheel.fate.utilities.Response;

import java.sql.Timestamp;

/**
 * Created by umer on 4/3/2018.
 */
public interface ScheduleFacade {
    Response generateSchedule(Timestamp timestamp);
}

package org.engineering.support.wheel.fate.interfaces.facade;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.interfaces.dto.ScheduleDto;
import org.engineering.support.wheel.fate.utilities.Response;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
public interface ScheduleFacade {
    Response generateSchedule(Long timestamp);
    ScheduleDto getSchedule(Long timestamp);
    Response deleteSchedule(Long timestamp);
}

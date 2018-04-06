package org.engineering.support.wheel.fate.facade;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.interfaces.facade.ScheduleFacade;
import org.engineering.support.wheel.fate.interfaces.facade.impl.ScheduleFacadeImpl;
import org.engineering.support.wheel.fate.service.ScheduleService;
import org.engineering.support.wheel.fate.utilities.Constants;
import org.engineering.support.wheel.fate.utilities.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by umer on 4/4/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ScheduleFacadeImplTest {
    @Mock
    ScheduleService scheduleService;

    @Mock
    Constants constants;

    @InjectMocks
    ScheduleFacade scheduleFacade = new ScheduleFacadeImpl();

    @Test
    public void testGenerateSchedule_whenScheduleNotGenerated() throws Exception {
        List<Shift> mockShifts = new ArrayList<>();
        mockShifts.add(getShift());
        when(constants.getNumberOfEngineers()).thenReturn(1);
        when(constants.getTotalDaysInWeek()).thenReturn(5);
        when(constants.getShiftsPerDay()).thenReturn(2);
        when(constants.getWeeksPerSchedule()).thenReturn(1);
        when(scheduleService.generateSchedule(1, 1, mockShifts)).thenReturn(true);

        Response actualResponse = scheduleFacade.generateSchedule(1L);

        assertThat(actualResponse.getData(), is("The schedule was not generated"));
        verify(scheduleService, times(0))
                .generateSchedule(1, 1, mockShifts);
    }

    private Shift getShift(){
        Engineer engineer = getEngineer();
        Shift shift = new Shift();
        shift.setId(1);
        shift.setCreationDate(new Timestamp(1));
        shift.setUpdationDate(new Timestamp(1));
        shift.setShiftDate(Date.valueOf(LocalDate.now()));
        shift.setEngineer(engineer);

        return shift;
    }

    private Engineer getEngineer(){
        Engineer engineer = new Engineer();
        engineer.setId(1);
        engineer.setFirstName("Alan");
        engineer.setLastName("Walker");
        engineer.setEmail("alan.walker@dummy.com");
        engineer.setUpdationDate(new Timestamp(1));
        engineer.setCreationDate(new Timestamp(1));

        return engineer;
    }
}

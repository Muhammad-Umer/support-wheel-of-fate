package org.engineering.support.wheel.fate;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by umer on 4/5/2018.
 */
public class BaseUnitTest {
    protected Shift getShift() {
        Engineer engineer = getEngineer();
        Shift shift = new Shift();
        shift.setId(1);
        shift.setCreationDate(new Timestamp(1));
        shift.setUpdationDate(new Timestamp(1));
        shift.setShiftDate(Date.valueOf(LocalDate.now()));
        shift.setEngineer(engineer);

        return shift;
    }

    protected Engineer getEngineer() {
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

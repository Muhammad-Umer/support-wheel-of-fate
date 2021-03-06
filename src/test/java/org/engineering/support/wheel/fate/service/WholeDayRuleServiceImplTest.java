package org.engineering.support.wheel.fate.service;

import org.engineering.support.wheel.fate.BaseUnitTest;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.service.impl.HalfDayShiftRuleServiceImpl;
import org.engineering.support.wheel.fate.service.impl.WholeDayRuleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by umer on 4/5/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class WholeDayRuleServiceImplTest extends BaseUnitTest{

    @InjectMocks
    RuleService ruleService = new WholeDayRuleServiceImpl();

    @Test
    public void testIfEngineerIsValid() throws Exception {
        List<Shift> shifts = new ArrayList<>();
        Shift mockShift1 = getShift();
        Shift mockShift2 = getShift();
        Shift mockShift3 = getShift();
        shifts.add(mockShift1);
        mockShift2.getEngineer().setId(2);
        shifts.add(mockShift2);
        shifts.add(mockShift3);

        boolean actualResult = ruleService.isValid(3, 2, shifts);
        assertThat(actualResult, is(true));

    }

    @Test
    public void testIfEngineerIsInValid() throws Exception {
        List<Shift> shifts = new ArrayList<>();
        Shift mockShift1 = getShift();
        Shift mockShift2 = getShift();
        Shift mockShift3 = getShift();
        shifts.add(mockShift1);
        mockShift2.getEngineer().setId(2);
        shifts.add(mockShift2);
        shifts.add(mockShift3);

        boolean actualResult = ruleService.isValid(3, 1, shifts);
        assertThat(actualResult, is(false));

    }
}
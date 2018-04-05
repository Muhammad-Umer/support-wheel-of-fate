package org.engineering.support.wheel.fate.interfaces.facade.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.interfaces.dto.ScheduleDto;
import org.engineering.support.wheel.fate.interfaces.dto.ShiftDto;
import org.engineering.support.wheel.fate.interfaces.facade.EngineerFacade;
import org.engineering.support.wheel.fate.interfaces.facade.ScheduleFacade;
import org.engineering.support.wheel.fate.service.ScheduleService;
import org.engineering.support.wheel.fate.utilities.Constants;
import org.engineering.support.wheel.fate.utilities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Component
public class ScheduleFacadeImpl implements ScheduleFacade {
    @Autowired
    Constants constants;

    @Autowired
    ScheduleService scheduleService;

    @Override
    public Response generateSchedule(Timestamp timestamp) {
        try {
            Integer numberOfEngineers = constants.getNumberOfEngineers();
            Integer weeksPerSchedule = constants.getWeeksPerSchedule();
            Integer numberOfShifts = weeksPerSchedule * constants.getTotalDaysInWeek() * constants.getShiftsPerDay();
            Integer totalDaysInScheduleWeeks = weeksPerSchedule * 7;

            int dayOfTheWeek = timestamp == null ? LocalDate.now().getDayOfWeek().getValue() :
                    LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.UTC).toLocalDate().getDayOfWeek().getValue();

            LocalDate scheduleStart = LocalDate.now()
                    .minusDays(dayOfTheWeek - 1);

            List<LocalDate> scheduleDates = new ArrayList<>();
            List<Shift> shifts = new ArrayList<>(numberOfShifts);

            int dayCounter = 1;
            for(int i = 0; i < totalDaysInScheduleWeeks; i++){
                if(dayCounter != 6 && dayCounter != 7){
                    LocalDate dayToAdd = scheduleStart.plusDays(i);
                    scheduleDates.add(dayToAdd);

                    Shift firstShift = new Shift();
                    firstShift.setShiftDate(Date.valueOf(dayToAdd));
                    shifts.add(firstShift);

                    Shift secondShift = new Shift();
                    secondShift.setShiftDate(Date.valueOf(dayToAdd));
                    shifts.add(secondShift);
                }else if(dayCounter == 7){
                    dayCounter = 0;
                }
                dayCounter++;
            }

            boolean scheduleGenerated = scheduleService.generateSchedule(numberOfEngineers, numberOfShifts, shifts);
            String response = scheduleGenerated ? "The schedule is generated successfully" : "The schedule was not generated";
            return new Response<>(response);
        }catch (Exception e){
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e);
        }
    }

    @Override
    public ScheduleDto getSchedule(Timestamp timestamp) {
        int dayOfTheWeek = timestamp == null ? LocalDate.now().getDayOfWeek().getValue() :
                LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.UTC).toLocalDate().getDayOfWeek().getValue();

        Integer numberOfShifts = constants.getWeeksPerSchedule() * constants.getTotalDaysInWeek() * constants.getShiftsPerDay();
        Date previousSunday = Date.valueOf(LocalDate.now()
                .minusDays(dayOfTheWeek));

        List<Shift> shifts =  scheduleService.getSchedule(previousSunday, numberOfShifts);

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setShiftDtos(scheduleDto.getSchedule(shifts));

        return scheduleDto;
    }
}

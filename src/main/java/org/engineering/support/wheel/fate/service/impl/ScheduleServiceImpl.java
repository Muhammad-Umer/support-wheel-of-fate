package org.engineering.support.wheel.fate.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.service.EngineerService;
import org.engineering.support.wheel.fate.service.EvaluatorService;
import org.engineering.support.wheel.fate.service.ScheduleService;
import org.engineering.support.wheel.fate.service.ShiftService;
import org.engineering.support.wheel.fate.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by umer on 4/3/2018.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    EngineerService engineerService;

    @Autowired
    ShiftService shiftService;

    @Autowired
    EvaluatorService evaluatorService;

    @Override
    public boolean generateSchedule(Integer numberOfEngineers, Integer numberOfShifts, List<Shift> shifts) throws Exception {
        Constants.engineersDoneForDay.clear();
        List<Engineer> engineers = engineerService.getRandomEngineers(numberOfEngineers);
        if(!CollectionUtils.isEmpty(engineers)){
            if(numberOfShifts / engineers.size() != 2){
                return false;
            }else{
                for(int i = 0; i < engineers.size(); i++){
                    shifts.get(i).setEngineer(engineers.get(i));
                }
                Collections.shuffle(engineers);
                while (shifts.get(shifts.size() - 1).getEngineer() == null){
                    for(int i = engineers.size(); i < numberOfShifts; i++){
                        for(int j = 0; j < engineers.size(); j++){
                            boolean valid = evaluatorService.evaluate(i,
                                    engineers.get(j).getId(), shifts);
                            if(valid){
                                shifts.get(i).setEngineer(engineers.get(j));
                                break;
                            }
                        }
                    }
                }
            }
        }
        shiftService.storeShifts(shifts);

        return true;
    }


    @Override
    public List<Shift> getSchedule(Date date, Integer numberOfShifts) {
        List<Shift> shifts = shiftService.getShiftsOfSchedule(date, numberOfShifts);
        return shifts;
    }
}

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
        List<Engineer> engineers = engineerService.getEngineers(numberOfEngineers);
        Constants.engineersRandomizer = engineers.stream()
                .collect(Collectors.toMap(e -> e.getId() - 1, Engineer::getId));
        if(!CollectionUtils.isEmpty(engineers)){
            for(int i = 0; i < numberOfShifts; i++){
                boolean valid = false;
                while (!valid){
                    int randomIndex = new Random().nextInt(engineers.size());
                    if(Constants.engineersRandomizer.containsKey(randomIndex)){
                        valid = evaluatorService.evaluate(i,
                                engineers.get(randomIndex).getId(), shifts);
                        if(valid){
                            shifts.get(i).setEngineer(engineers.get(randomIndex));
                        }
                    }
                }
            }
            Constants.engineersDoneForDay.clear();
            if(numberOfShifts / engineers.size() > 2){
                int difference = numberOfShifts - engineers.size();
                for(int i = shifts.size(); i > difference; i--){
                    int randomIndex = new Random().nextInt(engineers.size());
                    boolean valid = evaluatorService.evaluate(i, engineers.get(randomIndex).getId(), shifts);
                    if(valid){
                        shifts.get(i).setEngineer(engineers.get(randomIndex));
                    }
                }
            }
        }
        shiftService.storeShifts(shifts);

        return true;
    }
}

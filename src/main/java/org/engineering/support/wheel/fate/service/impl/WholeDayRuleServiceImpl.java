package org.engineering.support.wheel.fate.service.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.service.RuleService;
import org.engineering.support.wheel.fate.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umer on 4/2/2018.
 */
@Service
public class WholeDayRuleServiceImpl implements RuleService {

    @Override
    public boolean isValid(int shiftId, int engineerId, List<Shift> shifts) throws Exception{
        if(Constants.engineersDoneForDay.contains(engineerId)){
            return false;
        }
        int countPerEngineer = 0;
        for(int i = 0; i < shifts.size() ; i++){
            if(shifts.get(i).getEngineer() == null){
                break;
            }
            if(shifts.get(i).getEngineer().getId() == engineerId){
                countPerEngineer++;
                if(countPerEngineer > 1){
                    Constants.engineersDoneForDay.add(engineerId);
                    return false;
                }
            }
        }
        return true;
    }
}

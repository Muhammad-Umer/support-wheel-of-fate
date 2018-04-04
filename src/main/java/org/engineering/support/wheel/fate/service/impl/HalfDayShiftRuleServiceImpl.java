package org.engineering.support.wheel.fate.service.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by umer on 4/2/2018.
 */
@Service
public class HalfDayShiftRuleServiceImpl implements RuleService {

    @Override
    public boolean isValid(int shiftId, int engineerId, List<Shift> shifts) throws Exception{
        boolean valid = true;
        boolean morning = (shiftId + 1) % 2 != 0;
        if(shiftId < 1){
            return valid;
        }
        if(!morning){
            Optional<Boolean> result =  Optional.ofNullable(shifts.get(shiftId - 1).getEngineer().getId() == engineerId);
            if(result.isPresent()){
                valid = !result.get();
            }
        }
        return valid;
    }
}

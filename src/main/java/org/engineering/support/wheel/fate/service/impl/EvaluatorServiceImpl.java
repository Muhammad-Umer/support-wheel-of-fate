package org.engineering.support.wheel.fate.service.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.service.EvaluatorService;
import org.engineering.support.wheel.fate.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Service
public class EvaluatorServiceImpl implements EvaluatorService{

    @Autowired
    private List<RuleService> rules;

    @Override
    public boolean evaluate(int shiftId, int engineerId, List<Shift> shifts) throws Exception {
        boolean valid = true;
        for(RuleService rule: rules){
            valid = rule.isValid(shiftId, engineerId, shifts);
            if(!valid){
                return valid;
            }
        }

        return valid;
    }
}

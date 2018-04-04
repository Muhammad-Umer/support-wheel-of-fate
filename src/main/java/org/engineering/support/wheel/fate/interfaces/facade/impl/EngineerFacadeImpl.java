package org.engineering.support.wheel.fate.interfaces.facade.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.interfaces.facade.EngineerFacade;
import org.engineering.support.wheel.fate.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Component
public class EngineerFacadeImpl implements EngineerFacade {

    @Autowired
    EngineerService engineerService;

    @Override
    public List<Engineer> getEngineers(Integer limit) {
        try {
            return engineerService.getEngineers(limit);
        }catch (Exception e){
            return null;
        }
    }
}

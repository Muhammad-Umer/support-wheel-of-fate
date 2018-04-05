package org.engineering.support.wheel.fate.service;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;

import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
public interface EngineerService {
    List<Engineer> getEngineers(Integer limit) throws Exception;

    List<Engineer> getRandomEngineers(Integer limit) throws Exception;

    Engineer getEngineer(Integer engineerId) throws Exception;
}

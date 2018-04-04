package org.engineering.support.wheel.fate.service.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.EngineerRepository;
import org.engineering.support.wheel.fate.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Service
public class EngineerServiceImpl implements EngineerService {
    @Autowired
    EngineerRepository engineerRepository;

    @Override
    public List<Engineer> getEngineers(Integer limit) throws Exception{
        return engineerRepository.getEngineers(limit);
    }

    @Override
    public Engineer getEngineer(Integer engineerId) throws Exception{
        return engineerRepository.findById(engineerId);
    }
}

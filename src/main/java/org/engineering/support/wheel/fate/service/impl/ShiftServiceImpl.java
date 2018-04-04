package org.engineering.support.wheel.fate.service.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.ShiftRepository;
import org.engineering.support.wheel.fate.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    ShiftRepository shiftRepository;

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void storeShifts(List<Shift> shifts) throws Exception {
        for(Shift shift : shifts){
            shiftRepository.persist(shift);
        }
    }
}

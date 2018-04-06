package org.engineering.support.wheel.fate.interfaces.facade.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.interfaces.facade.ShiftFacade;
import org.engineering.support.wheel.fate.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by umer on 4/7/2018.
 */
@Component
public class ShiftFacadeImpl implements ShiftFacade{

    @Autowired
    ShiftService shiftService;

    @Override
    public Shift getShiftsByDate(Date date) {
        return shiftService.getShiftsByDate(date);
    }
}

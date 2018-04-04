package org.engineering.support.wheel.fate.service;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
public interface EvaluatorService {
    boolean evaluate(int shiftId, int engineerId, List<Shift> shifts) throws Exception;
}

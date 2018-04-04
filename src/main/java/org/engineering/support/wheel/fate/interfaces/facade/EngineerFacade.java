package org.engineering.support.wheel.fate.interfaces.facade;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;

import java.util.List;

/**
 * Created by umer on 4/3/2018.
 */
public interface EngineerFacade {
    List<Engineer> getEngineers(Integer limit);
}

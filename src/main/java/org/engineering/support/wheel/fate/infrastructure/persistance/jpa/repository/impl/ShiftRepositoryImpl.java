package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.impl;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.repository.ShiftRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by umer on 4/3/2018.
 */
@Repository
public class ShiftRepositoryImpl extends MainRepositoryImpl<Shift> implements ShiftRepository {
}

package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.common;

/**
 * Created by umer on 4/2/2018.
 */
public interface GenericEntity<E> {
    void setId(E id);
    E getId();
}

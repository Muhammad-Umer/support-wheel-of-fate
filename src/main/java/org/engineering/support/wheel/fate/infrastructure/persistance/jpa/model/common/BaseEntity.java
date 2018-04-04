package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.common;

import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created by umer on 4/2/2018.
 */
@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseEntity implements GenericEntity<Integer>{
    protected Integer id;
    protected Timestamp creationDate;

    public BaseEntity(){
        creationDate = new Timestamp(System.currentTimeMillis());
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "creation_date")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}

package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model;

import lombok.Setter;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by umer on 4/2/2018.
 */
@Entity
@Table(name = "shift")
@NamedQueries({
        @NamedQuery(name = "getShiftsOfSchedule", query = "select s from Shift s where s.shiftDate > :shiftDate")
})
@Setter
public class Shift extends BaseEntity{
    private Engineer engineer;
    private Date shiftDate;
    private Timestamp updationDate;

    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "engineer_id")
    public Engineer getEngineer() {
        return engineer;
    }

    @Column(name = "shift_date")
    public Date getShiftDate() {
        return shiftDate;
    }

    @Column(name = "updation_date")
    public Timestamp getUpdationDate() {
        return updationDate;
    }
}

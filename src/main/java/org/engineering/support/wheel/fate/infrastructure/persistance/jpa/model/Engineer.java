package org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model;

import lombok.Setter;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by umer on 4/2/2018.
 */
@Entity
@Table(name = "engineer")
@NamedQueries({
        @NamedQuery(name = "getEngineers", query = "select e from Engineer e")
})
@Setter
public class Engineer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp updationDate;

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "updation_date")
    public Timestamp getUpdationDate() {
        return updationDate;
    }
}

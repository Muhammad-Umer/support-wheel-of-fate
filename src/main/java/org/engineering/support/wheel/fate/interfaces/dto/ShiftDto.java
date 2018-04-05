package org.engineering.support.wheel.fate.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.sql.Date;

/**
 * Created by umer on 4/5/2018.
 */
@JsonAutoDetect
@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShiftDto {
    private Integer shiftId;
    private EngineerDto engineerDto;
    private Date shiftDate;

    public ShiftDto(Shift shift){
        this.shiftId = shift.getId();
        this.engineerDto = new EngineerDto(shift.getEngineer());
        this.shiftDate = shift.getShiftDate();
    }
}

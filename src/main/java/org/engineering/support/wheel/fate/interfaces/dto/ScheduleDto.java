package org.engineering.support.wheel.fate.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Shift;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by umer on 4/5/2018.
 */
@JsonAutoDetect
@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ScheduleDto {
    private List<ShiftDto> shiftDtos;

    public List<ShiftDto> getSchedule(List<Shift> shifts){
        return shifts.stream().map(s -> {
            return new ShiftDto(s);
        }).collect(Collectors.toList());
    }
}

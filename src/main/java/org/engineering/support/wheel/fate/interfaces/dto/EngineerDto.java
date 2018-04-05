package org.engineering.support.wheel.fate.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;

/**
 * Created by umer on 4/5/2018.
 */
@JsonAutoDetect
@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EngineerDto {
    private Integer engineerId;
    private String firstName;
    private String lastName;
    private String email;

    public EngineerDto(Engineer engineer){
        this.engineerId = engineer.getId();
        this.firstName = engineer.getFirstName();
        this.lastName = engineer.getLastName();
        this.email = engineer.getEmail();
    }
}

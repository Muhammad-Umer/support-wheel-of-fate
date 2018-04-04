package org.engineering.support.wheel.fate.utilities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * Created by umer on 4/2/2018.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<E> {
    private int status;
    private E data;

    public Response(E data){
        this.data = data;
        this.status = HttpStatus.OK.value();
    }
}

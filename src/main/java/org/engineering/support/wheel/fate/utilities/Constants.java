package org.engineering.support.wheel.fate.utilities;

import lombok.Data;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by umer on 4/3/2018.
 */
@Data
@Component
public class Constants {
    private final int totalDaysInWeek = 5;

    @Value("${properties.number-of-engineers:10}")
    private Integer numberOfEngineers;

    @Value("${properties.weeks-per-schedule:2}")
    private Integer weeksPerSchedule;

    @Value("${properties.shifts-per-day:2}")
    private Integer shiftsPerDay;

    public static Set<Integer> engineersDoneForDay = new HashSet<>();

    public static Map<Integer, Integer> engineersRandomizer  = new HashMap<>();

    private Constants(){}
}

package org.engineering.support.wheel.fate.interfaces.controllers;

import org.engineering.support.wheel.fate.interfaces.dto.ScheduleDto;
import org.engineering.support.wheel.fate.interfaces.facade.ScheduleFacade;
import org.engineering.support.wheel.fate.utilities.Response;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umer on 4/3/2018.
 */
@ApiVersion(since = "1.0", until = "2.0")
@RestController
@RequestMapping("v{apiVersion}/schedule/")
public class ScheduleController {

    @Autowired
    ScheduleFacade scheduleFacade;

    @RequestMapping(value = "generate", method = RequestMethod.GET)
    public Response generateSchedule(@PathVariable Integer apiVersion) {
        return scheduleFacade.generateSchedule(null);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Response<ScheduleDto> getSchedule(@PathVariable Integer apiVersion) {
        return new Response<>(scheduleFacade.getSchedule(null));
    }
}

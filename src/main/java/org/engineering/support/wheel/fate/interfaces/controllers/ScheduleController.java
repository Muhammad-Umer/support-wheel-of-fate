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

    @RequestMapping(value = "generate/{timestamp}", method = RequestMethod.POST)
    public Response generateSchedule(@PathVariable Integer apiVersion, @PathVariable Long timestamp) {
        return scheduleFacade.generateSchedule(timestamp);
    }

    @RequestMapping(value = "get/{timestamp}", method = RequestMethod.GET)
    public Response<ScheduleDto> getSchedule(@PathVariable Integer apiVersion, @PathVariable Long timestamp) {
        return new Response<>(scheduleFacade.getSchedule(timestamp));
    }

    @RequestMapping(value = "delete/{timestamp}", method = RequestMethod.DELETE)
    public Response deleteSchedule(@PathVariable Integer apiVersion, @PathVariable Long timestamp) {
        return scheduleFacade.deleteSchedule(timestamp);
    }

}

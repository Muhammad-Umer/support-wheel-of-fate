package org.engineering.support.wheel.fate.interfaces.controllers;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.interfaces.facade.EngineerFacade;
import org.engineering.support.wheel.fate.interfaces.facade.ScheduleFacade;
import org.engineering.support.wheel.fate.utilities.Response;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by umer on 4/2/2018.
 */
@ApiVersion(since = "1.0", until = "2.0")
@RestController
@RequestMapping("v{apiVersion}/engineer/")
public class EngineerController {

    @Autowired
    EngineerFacade engineerFacade;

    @Autowired
    ScheduleFacade scheduleFacade;

    @RequestMapping(value = "get/{limit}", method = RequestMethod.GET)
    public Response<List<Engineer>> getEngineers(@PathVariable Integer apiVersion, @PathVariable Integer limit) {
        return new Response<>(engineerFacade.getEngineers(limit));
    }
}

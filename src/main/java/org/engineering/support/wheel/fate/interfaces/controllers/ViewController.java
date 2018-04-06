package org.engineering.support.wheel.fate.interfaces.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by umer on 4/6/2018.
 */
@Controller
public class ViewController {
    @RequestMapping(value="/index, /", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "index";
    }
}

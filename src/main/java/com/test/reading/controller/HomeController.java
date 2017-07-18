package com.test.reading.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by ryan on 6/28/17.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(ModelMap modelMap) throws IOException {
        modelMap.put("name", "Hello Ryan!");

        return "index";
    }
}

package com.test.reading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by ryan on 7/1/17.
 */
@RestController
@RequestMapping("/user")
public class UserDataController {

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAll(@RequestParam(value = "ids") String[] ids){
        System.out.println("ids=" + ids.length);
        System.out.println(ids[0]);
        System.out.println(ids[1]);

        return Arrays.stream(ids).collect(Collectors.joining(","));

    }

}

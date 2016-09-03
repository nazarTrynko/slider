package com.trynko.sliderjs.controller;

import com.google.gson.Gson;
import com.trynko.sliderjs.constants.sliderConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 * Created by К on 01.09.2016.
 */
@Controller
public class RandomNumberController {
    @RequestMapping(value = "/")
    public ModelAndView helloWorld() {
        ModelAndView model = new ModelAndView();
        model.setViewName("slider");
        ModelMap modelMap = model.getModelMap();
        modelMap.addAttribute("slidersize", sliderConstants.sliderSize);
        return model;
    }

    @RequestMapping(value="generate")
    @ResponseBody
    public String generate() {
        Random rand = new Random();
        int  n = rand.nextInt(sliderConstants.sliderSize);
        return new Gson().toJson(n);
    }
}

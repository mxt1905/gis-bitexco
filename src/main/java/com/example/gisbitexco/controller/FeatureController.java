package com.example.gisbitexco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * FeatureController
 */
@Controller
public class FeatureController {

    @GetMapping("/feature")
    public ModelAndView feature() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("feature");
        return mav;
    }
}

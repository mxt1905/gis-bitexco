package com.example.gisbitexco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * MapController
 */
@Controller
public class MapController {

    @RequestMapping("/map")
    public ModelAndView showMap3DPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("map3d");
        return mav;
    }
}

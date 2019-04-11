package com.zoy.graduation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zouzp on 2019/4/11.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("world")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("thymeleaf_template_show");
        modelAndView.addObject("host", "www.zoy.com");
        return modelAndView;
    }
}

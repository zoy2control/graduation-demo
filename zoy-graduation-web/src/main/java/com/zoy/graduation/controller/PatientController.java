package com.zoy.graduation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zouzp on 2019/4/14.
 */
@RestController
@RequestMapping("patient")
public class PatientController {

    @GetMapping("show/register")
    public ModelAndView showRegister() {
        ModelAndView mv = new ModelAndView("patient/register");
        return mv;
    }

    /**
     * ·注册
     */
    @PostMapping("register")
    public void register() {

    }
}

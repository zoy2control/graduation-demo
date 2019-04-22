package com.zoy.graduation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zouzp on 2019/4/16.
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("admin/home");
        return mv;
    }

    @GetMapping("show/patient")
    public ModelAndView showPatient() {
        ModelAndView mv = new ModelAndView("admin/show_patient");
        return mv;
    }

    @GetMapping("show/doctor")
    public ModelAndView showDoctor() {
        ModelAndView mv = new ModelAndView("admin/show_doctor");
        return mv;
    }

    /**
     * ·查看患者详情页面
     * @return
     */
    @GetMapping("patient/detail")
    public ModelAndView patientDetail() {
        ModelAndView mv = new ModelAndView("admin/patient_detail");
        return mv;
    }
}

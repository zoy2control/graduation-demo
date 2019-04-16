package com.zoy.graduation.controller;

import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;
import com.zoy.graduation.service.IDoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/16.
 */
@RestController()
@RequestMapping("doctor")
public class DoctorController {

    @Resource
    private IDoctorService doctorService;

    @GetMapping("show/register")
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView("doctor/register");
        return modelAndView;
    }

    @PostMapping("register")
    public void register(DoctorRegisterDTO doctorRegisterDTO) {
        doctorService.register(doctorRegisterDTO);
    }
}

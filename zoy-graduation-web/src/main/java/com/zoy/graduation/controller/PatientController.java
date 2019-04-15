package com.zoy.graduation.controller;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import com.zoy.graduation.service.IPatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/14.
 */
@RestController
@RequestMapping("patient")
public class PatientController {

    @Resource
    private IPatientService patientService;

    @GetMapping("show/register")
    public ModelAndView showRegister() {
        ModelAndView mv = new ModelAndView("patient/register");
        return mv;
    }

    /**
     * ·注册
     */
    @PostMapping("register")
    public void register(PatientInfoDTO patientInfoDTO) {
        System.out.println(patientInfoDTO.getAccount());
        patientService.register(patientInfoDTO);
    }
}

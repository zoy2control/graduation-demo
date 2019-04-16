package com.zoy.graduation.controller;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import com.zoy.graduation.service.IPatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/15.
 */
@RestController
public class PatientController {
    @Resource
    private IPatientService patientService;

    @PostMapping("register")
    public void register(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientService.register(patientInfoDTO);
    }
}

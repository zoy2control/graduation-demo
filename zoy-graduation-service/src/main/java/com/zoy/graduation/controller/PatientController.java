package com.zoy.graduation.controller;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zouzp on 2019/4/15.
 */
@RestController
public class PatientController {
    @PostMapping("register")
    public void register(@RequestBody PatientInfoDTO patientInfoDTO) {

    }
}

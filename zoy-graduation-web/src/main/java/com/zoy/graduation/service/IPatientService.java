package com.zoy.graduation.service;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by zouzp on 2019/4/15.
 */
@FeignClient(url="${zoy.graduation.service.url:}", value="zoy-graduation-service")
public interface IPatientService {
    @PostMapping("register")
    public void register(@RequestBody PatientInfoDTO patientInfoDTO);
}

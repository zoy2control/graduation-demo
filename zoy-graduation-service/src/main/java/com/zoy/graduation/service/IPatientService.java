package com.zoy.graduation.service;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import org.springframework.stereotype.Service;

/**
 * Created by zouzp on 2019/4/15.
 */
@Service
public interface IPatientService {
    public void register(PatientInfoDTO patientInfoDTO);
}

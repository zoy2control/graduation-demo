package com.zoy.graduation.service.impl;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import com.zoy.graduation.mapper.IPatientInfoMapper;
import com.zoy.graduation.service.IPatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/15.
 */
@Service
public class PatientServiceImpl implements IPatientService {
    @Resource
    private IPatientInfoMapper patientInfoMapper;
    @Override
    public void register(PatientInfoDTO patientInfoDTO) {
//        patientInfoMapper.register(patientInfoDTO);
        patientInfoMapper.insertSelective(patientInfoDTO);
    }
}

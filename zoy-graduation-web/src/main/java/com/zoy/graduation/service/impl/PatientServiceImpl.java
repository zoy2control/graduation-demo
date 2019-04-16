package com.zoy.graduation.service.impl;

import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.entity.patient.PatientRegisterDTO;
import com.zoy.graduation.mapper.IPatientInfoMapper;
import com.zoy.graduation.service.IPatientService;
import com.zoy.graduation.utils.AssembleUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by zouzp on 2019/4/15.
 */
@Service
public class PatientServiceImpl implements IPatientService {

    @Resource
    private IPatientInfoMapper patientInfoMapper;

    @Resource
    private AssembleUtil assembleUtil;

    @Override
    public void register(PatientRegisterDTO patientRegisterDTO) {
        PatientInfo patientInfo = assembleUtil.assemblePatientInfo(patientRegisterDTO);
        int patientId = 10 + (int) (Math.random() * 1000000000);
        patientInfo.setPatientId(patientId);
        patientInfoMapper.insertSelective(patientInfo);
    }
}

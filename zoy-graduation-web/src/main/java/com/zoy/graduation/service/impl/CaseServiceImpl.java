package com.zoy.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.caseInfo.PatientCase;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.mapper.ICaseInfoMapper;
import com.zoy.graduation.service.ICaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
@Service
public class CaseServiceImpl implements ICaseService {

    @Resource
    private ICaseInfoMapper caseInfoMapper;

    @Override
    public PageInfo<CaseInfo> findByPatientId(PatientInfo patientInfo) {
        PageHelper.startPage(0,15);
        List<CaseInfo> resultList = caseInfoMapper.findByPatientId(patientInfo);
        PageInfo<CaseInfo> pageInfo = new PageInfo<>(resultList);
        return pageInfo;
    }

    @Override
    public CaseInfo findByCaseId(long caseId) {
        CaseInfo caseInfo = caseInfoMapper.findByCaseId(caseId);
        return caseInfo;
    }

    @Override
    public void updateByCaseId(CaseInfo caseInfo) {
        caseInfo.setVisitTime(new Date());
        caseInfoMapper.updateByCaseId(caseInfo);
    }

    @Override
    public void addCase(CaseInfo caseInfo) {
        long caseId = 10 + (long) (Math.random() * 1000000000);
        PatientCase patientCase = new PatientCase();
        patientCase.setCaseId(caseId);
        patientCase.setVisitTime(new Date());
        patientCase.setDoctorId(caseInfo.getDoctorId());
        patientCase.setDoctorName(caseInfo.getDoctorName());
        patientCase.setDoctorName(caseInfo.getDoctorName());
        patientCase.setMedicineName(caseInfo.getMedicineName());
        patientCase.setMedicineNum(caseInfo.getMedicineNum());
        patientCase.setPatientId(caseInfo.getPatientId());
        patientCase.setState(caseInfo.getState());
        caseInfoMapper.insertSelective(patientCase);
    }
}

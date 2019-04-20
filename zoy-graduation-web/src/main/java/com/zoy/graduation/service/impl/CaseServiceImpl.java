package com.zoy.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.mapper.ICaseInfoMapper;
import com.zoy.graduation.service.ICaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}

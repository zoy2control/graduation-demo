package com.zoy.graduation.service;

import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.patient.PatientInfo;
import org.apache.ibatis.annotations.Case;

import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
public interface ICaseService {
    public PageInfo<CaseInfo> findByPatientId(PatientInfo patientInfo);
    public CaseInfo findByCaseId(long caseId);
    public void updateByCaseId(CaseInfo caseInfo);
    public void addCase(CaseInfo caseInfo);
}

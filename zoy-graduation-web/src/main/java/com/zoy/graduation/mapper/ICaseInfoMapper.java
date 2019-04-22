package com.zoy.graduation.mapper;

import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.caseInfo.PatientCase;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.utils.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
@Mapper
public interface ICaseInfoMapper extends IBaseMapper<PatientCase> {
    public List<CaseInfo> findByPatientId(PatientInfo patientInfo);
    public CaseInfo findByCaseId(@Param("caseId") long caseId);
    public void updateByCaseId(CaseInfo caseInfo);
    public void insertNew(CaseInfo caseInfo);
}

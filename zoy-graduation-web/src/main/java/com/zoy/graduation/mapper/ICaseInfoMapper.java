package com.zoy.graduation.mapper;

import com.zoy.graduation.entity.caseInfo.CaseInfo;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.utils.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
@Mapper
public interface ICaseInfoMapper extends IBaseMapper<CaseInfo> {
    public List<CaseInfo> findByPatientId(PatientInfo patientInfo);
}

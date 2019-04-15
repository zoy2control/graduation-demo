package com.zoy.graduation.mapper;

import com.zoy.graduation.dto.patient.PatientInfoDTO;
import com.zoy.graduation.utils.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by zouzp on 2019/4/15.
 */
@Mapper
public interface IPatientInfoMapper extends IBaseMapper<PatientInfoDTO> {
    void register(PatientInfoDTO patientInfoDTO);
}

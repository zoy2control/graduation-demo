package com.zoy.graduation.mapper;

import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.utils.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zouzp on 2019/4/16.
 */
@Mapper
public interface IDoctorInfoMapper extends IBaseMapper<DoctorInfo> {
    public void updateByDoctorId(DoctorInfo doctorInfo);
    public DoctorInfo findByDoctorId(@Param("doctorId") long doctorId);
    public void deleteByDoctorId(@Param("doctorId") long doctorId);
}

package com.zoy.graduation.service;

import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;

/**
 * Created by zouzp on 2019/4/16.
 */
public interface IDoctorService {
    public void register(DoctorRegisterDTO doctorRegisterDTO);

    public DoctorInfo findByDoctorId(long doctorId);

    public PageInfo<DoctorInfo> queryAll();

    public void updateByDoctorId(DoctorInfo doctorInfo);

    public void deleteByDoctorId(long doctorId);
}

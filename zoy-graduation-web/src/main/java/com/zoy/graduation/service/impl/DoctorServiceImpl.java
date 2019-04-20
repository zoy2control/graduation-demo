package com.zoy.graduation.service.impl;

import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;
import com.zoy.graduation.mapper.IDoctorInfoMapper;
import com.zoy.graduation.service.IDoctorService;
import com.zoy.graduation.utils.AssembleUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zouzp on 2019/4/16.
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

    @Resource
    private IDoctorInfoMapper doctorInfoMapper;

    @Resource
    private AssembleUtil assembleUtil;

    @Override
    public void register(DoctorRegisterDTO doctorRegisterDTO) {
        DoctorInfo doctorInfo = assembleUtil.assembleDoctorInfo(doctorRegisterDTO);
        int doctorId = 10 + (int) (Math.random() * 1000000000);
        doctorInfo.setDoctorId(doctorId);
        doctorInfoMapper.insertSelective(doctorInfo);
    }

    @Override
    public DoctorInfo findByDoctorId(int doctorId) {
        DoctorInfo doctorInfo = new DoctorInfo();
        if (0 != doctorId) {
            doctorInfo.setDoctorId(doctorId);
        }
        DoctorInfo result = doctorInfoMapper.selectOne(doctorInfo);
        return result;
    }
}

package com.zoy.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;
import com.zoy.graduation.mapper.IAccountInfoMapper;
import com.zoy.graduation.mapper.IDoctorInfoMapper;
import com.zoy.graduation.service.IDoctorService;
import com.zoy.graduation.utils.AssembleUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zouzp on 2019/4/16.
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

    @Resource
    private IDoctorInfoMapper doctorInfoMapper;

    @Resource
    private IAccountInfoMapper accountInfoMapper;

    @Resource
    private AssembleUtil assembleUtil;

    @Override
    public void register(DoctorRegisterDTO doctorRegisterDTO) {
        DoctorInfo doctorInfo = assembleUtil.assembleDoctorInfo(doctorRegisterDTO);
        int doctorId = 10 + (int) (Math.random() * 1000000000);
        doctorInfo.setDoctorId(doctorId);
        doctorInfoMapper.insertSelective(doctorInfo);

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(doctorRegisterDTO.getAccount());
        accountInfo.setPassword(doctorRegisterDTO.getPassword());
        accountInfo.setPrivilege(1);
        accountInfo.setDoctorId(doctorId);
        accountInfoMapper.insertSelective(accountInfo);
    }

    @Override
    public DoctorInfo findByDoctorId(long doctorId) {
        DoctorInfo result = doctorInfoMapper.findByDoctorId(doctorId);
        return result;
    }

    @Override
    public PageInfo<DoctorInfo> queryAll() {
        PageHelper.startPage(0,15);
        List<DoctorInfo> doctorInfos = doctorInfoMapper.selectAll();
        PageInfo<DoctorInfo> result = new PageInfo<>(doctorInfos);
        return result;
    }

    @Override
    public void updateByDoctorId(DoctorInfo doctorInfo) {
        doctorInfoMapper.updateByDoctorId(doctorInfo);
    }

    @Override
    public void deleteByDoctorId(long doctorId) {
        doctorInfoMapper.deleteByDoctorId(doctorId);
    }
}

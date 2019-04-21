package com.zoy.graduation.service.impl;

import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.entity.patient.PatientRegisterDTO;
import com.zoy.graduation.mapper.IPatientInfoMapper;
import com.zoy.graduation.service.IAccountService;
import com.zoy.graduation.service.IPatientService;
import com.zoy.graduation.utils.AssembleUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zouzp on 2019/4/15.
 */
@Service
public class PatientServiceImpl implements IPatientService {

    @Resource
    private IPatientInfoMapper patientInfoMapper;

    @Resource
    private IAccountService accountService;

    @Resource
    private AssembleUtil assembleUtil;

    @Override
    public void register(PatientRegisterDTO patientRegisterDTO) {
        // ·患者个人信息落库
        PatientInfo patientInfo = assembleUtil.assemblePatientInfo(patientRegisterDTO);
        int patientId = 10 + (int) (Math.random() * 1000000000);
        patientInfo.setPatientId(patientId);
        patientInfoMapper.insertSelective(patientInfo);

        // ·患者账号信息落库
        AccountInfo accountInfo = new AccountInfo();
        if (null != patientRegisterDTO.getAccount()) {
            accountInfo.setAccount(patientRegisterDTO.getAccount());
        }
        if (null != patientRegisterDTO.getPassword()) {
            accountInfo.setPassword(patientRegisterDTO.getPassword());
        }
        accountInfo.setPrivilege(2);// ·患者的权限
        accountInfo.setPatientId(patientId);// ·患者id
        accountService.register(accountInfo);// ·账号注册
    }

    @Override
    public PatientInfo queryByPatientId(PatientInfo patientInfo) {
        PatientInfo result = patientInfoMapper.selectByPatientId(patientInfo);
        if (null != result) {
            return result;
        }
        return null;
    }
}

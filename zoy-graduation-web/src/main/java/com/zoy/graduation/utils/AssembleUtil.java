package com.zoy.graduation.utils;

import com.zoy.graduation.entity.doctor.DoctorInfo;
import com.zoy.graduation.entity.doctor.DoctorRegisterDTO;
import com.zoy.graduation.entity.patient.PatientInfo;
import com.zoy.graduation.entity.patient.PatientRegisterDTO;
import org.springframework.stereotype.Service;

/**
 * Created by zouzp on 2019/4/16.
 */
@Service
public class AssembleUtil {
    public PatientInfo assemblePatientInfo(PatientRegisterDTO registerDTO) {
        PatientInfo patientInfo = new PatientInfo();
        if (null != registerDTO.getName()) {
            patientInfo.setName(registerDTO.getName());
        }
        if (0 != registerDTO.getAge()) {
            patientInfo.setAge(registerDTO.getAge());
        }
        if (null != registerDTO.getSex()) {
            patientInfo.setSex(registerDTO.getSex());
        }
        if (null != registerDTO.getTel()) {
            patientInfo.setTel(registerDTO.getTel());
        }
        if (null != registerDTO.getAddr()) {
            patientInfo.setAddr(registerDTO.getAddr());
        }
        if (null != registerDTO.getMarriage()) {
            patientInfo.setMarriage(registerDTO.getMarriage());
        }
        if (null != registerDTO.getCompany()) {
            patientInfo.setCompany(registerDTO.getCompany());
        }
        if (null != registerDTO.getIdentityNum()) {
            patientInfo.setIdentityNum(registerDTO.getIdentityNum());
        }
        if (-1 != registerDTO.getCaseId()) {
            patientInfo.setCaseId(registerDTO.getCaseId());
        }
        return patientInfo;
    }


    public DoctorInfo assembleDoctorInfo(DoctorRegisterDTO doctorRegisterDTO) {
        DoctorInfo doctorInfo = new DoctorInfo();
        if (null != doctorRegisterDTO.getName()) {
            doctorInfo.setName(doctorRegisterDTO.getName());
        }
        if (0 != doctorRegisterDTO.getAge()) {
            doctorInfo.setAge(doctorRegisterDTO.getAge());
        }
        if (null != doctorRegisterDTO.getSex()) {
            doctorInfo.setSex(doctorRegisterDTO.getSex());
        }
        if (0 != doctorRegisterDTO.getWorkAge()) {
            doctorInfo.setWorkAge(doctorRegisterDTO.getWorkAge());
        }
        if (null != doctorRegisterDTO.getJobTitle()) {
            doctorInfo.setJobTitle(doctorRegisterDTO.getJobTitle());
        }
        if (null != doctorRegisterDTO.getDepartment()) {
            doctorInfo.setDepartment(doctorRegisterDTO.getDepartment());
        }
        return doctorInfo;
    }
}

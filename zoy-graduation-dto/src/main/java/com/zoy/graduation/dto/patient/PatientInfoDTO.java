package com.zoy.graduation.dto.patient;

import lombok.Data;

/**
 * Created by zouzp on 2019/4/14.
 */
@Data
public class PatientInfoDTO {
    private int patientId;
    private String account;
    private String password;
    private int privilege;
    private String name;
    private int age;
    private String sex;
    private String tel;
    private String addr;
    private String marriage;
    private String company;
    private String identityNum;
    private int caseId;
}
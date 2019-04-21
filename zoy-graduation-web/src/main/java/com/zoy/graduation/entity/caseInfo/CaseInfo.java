package com.zoy.graduation.entity.caseInfo;

import lombok.Data;

import java.util.Date;

/**
 * Created by zouzp on 2019/4/20.
 */
@Data
public class CaseInfo {
    /**
     * ·病例id
     */
    private int caseId;
    /**
     * ·患者id
     */
    private int patientId;
    /**
     * ·医生id
     */
    private int doctorId;
    /**
     * ·病况
     */
    private String state;
    /**
     * ·药名
     */
    private String medicineName;
    /**
     * ·药数量
     */
    private int medicineNum;
    /**
     * ·医生姓名
     */
    private String doctorName;
    /**
     * ·就诊时间
     */
    private Date visitTime;
}

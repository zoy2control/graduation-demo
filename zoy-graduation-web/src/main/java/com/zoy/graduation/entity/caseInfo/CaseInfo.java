package com.zoy.graduation.entity.caseInfo;

import lombok.Data;

import java.util.Date;

/**
 * Created by zouzp on 2019/4/20.
 */
@Data
public class CaseInfo {
    private int caseId;
    private int patientId;
    private String medicineName;
    private int medicineNum;
    private String docterName;
    private Date visitTime;
}

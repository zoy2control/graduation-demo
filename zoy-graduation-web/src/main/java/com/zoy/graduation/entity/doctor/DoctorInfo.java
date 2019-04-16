package com.zoy.graduation.entity.doctor;

import lombok.Data;

/**
 * Created by zouzp on 2019/4/16.
 */
@Data
public class DoctorInfo {
    private int doctorId;
    private String name;
    private int age;
    private int workAge;
    private String sex;
    private String jobTitle;
    private String department;
}

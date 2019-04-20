package com.zoy.graduation.entity.account;

import lombok.Data;

/**
 * Created by zouzp on 2019/4/20.
 */
@Data
public class AccountInfo {
    private String account;
    private String password;
    private int privilege;
    private int patientId;
    private int doctorId;
}

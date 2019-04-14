package com.zoy.graduation.dto.account;

import lombok.Data;

/**
 * Created by zouzp on 2019/4/14.
 */
@Data
public class AccountInfoDTO {
    /**
     * ·账号
     */
    private String account;
    /**
     * ·密码
     */
    private String password;
    /**
     * ·权限（0：管理员，1：医生，2：患者）
     */
    private int privilege;
}

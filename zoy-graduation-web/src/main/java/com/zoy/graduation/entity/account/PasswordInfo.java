package com.zoy.graduation.entity.account;

import lombok.Data;

/**
 * Created by zouzp on 2019/4/20.
 */
@Data
public class PasswordInfo {
    /**
     * ·医生id
     */
    private int doctorId;
    /**
     * ·用户名
     */
    private String account;
    /**
     * ·原始密码
     */
    private String oldPassword;
    /**
     * ·新密码
     */
    private String newPassword;
    /**
     * ·确认密码
     */
    private String comfirmPassword;
}

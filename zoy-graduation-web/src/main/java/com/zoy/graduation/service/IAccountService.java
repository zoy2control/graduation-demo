package com.zoy.graduation.service;

import com.zoy.graduation.entity.account.AccountInfo;

/**
 * Created by zouzp on 2019/4/20.
 */
public interface IAccountService {
    public void register(AccountInfo accountInfo);
    public AccountInfo checkAccount(AccountInfo accountInfo);
    public void modifyPassword(AccountInfo accountInfo);
    public AccountInfo findByDoctorId(AccountInfo accountInfo);
}

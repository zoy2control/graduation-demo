package com.zoy.graduation.service.impl;

import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.mapper.IAccountInfoMapper;
import com.zoy.graduation.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountInfoMapper accountInfoMapper;

    @Override
    public void register(AccountInfo accountInfo) {
        accountInfoMapper.insertSelective(accountInfo);
    }

    @Override
    public AccountInfo checkAccount(AccountInfo accountInfo) {
        List<AccountInfo> result = accountInfoMapper.findByCondition(accountInfo);
        if (null != result && !result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void modifyPassword(AccountInfo accountInfo) {
        accountInfoMapper.updatePassword(accountInfo);
    }

    @Override
    public AccountInfo findByDoctorId(AccountInfo accountInfo) {
        List<AccountInfo> resultList = accountInfoMapper.selectByDoctorId(accountInfo);
        if (null != resultList && !resultList.isEmpty()) {
            AccountInfo result = resultList.get(0);
            if (result.getPrivilege() == 1) {
                return result;
            }
        }
        return null;
    }
}

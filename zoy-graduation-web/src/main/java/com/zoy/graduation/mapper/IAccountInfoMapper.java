package com.zoy.graduation.mapper;

import com.zoy.graduation.entity.account.AccountInfo;
import com.zoy.graduation.utils.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zouzp on 2019/4/20.
 */
@Mapper
public interface IAccountInfoMapper extends IBaseMapper<AccountInfo> {
    public List<AccountInfo> findByCondition(AccountInfo accountInfo);
    public void updatePassword(AccountInfo accountInfo);
}

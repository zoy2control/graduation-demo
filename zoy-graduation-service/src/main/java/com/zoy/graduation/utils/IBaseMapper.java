package com.zoy.graduation.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by zouzp on 2019/4/15.
 */
public interface IBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

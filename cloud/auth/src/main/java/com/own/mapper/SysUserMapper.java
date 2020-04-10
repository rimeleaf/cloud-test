package com.own.mapper;


import com.own.entity.SysUser;

/**
 * Created by smlz on 2019/12/20.
 */
public interface SysUserMapper {

    SysUser findByUserName(String userName);
}

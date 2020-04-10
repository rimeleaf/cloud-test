package com.own.service;


import com.tuling.config.role.entity.SysUser;

/**
 * Created by smlz on 2019/12/20.
 */
public interface ISysUserService {

    SysUser getByUsername(String username);
}

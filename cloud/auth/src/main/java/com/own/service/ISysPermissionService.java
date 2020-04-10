package com.own.service;



import com.own.entity.SysPermission;

import java.util.List;

/**
 * Created by smlz on 2019/12/20.
 */
public interface ISysPermissionService {

    List<SysPermission> findByUserId(Integer userId);
}

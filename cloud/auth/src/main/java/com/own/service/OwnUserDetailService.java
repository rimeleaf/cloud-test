package com.own.service;

import com.alibaba.fastjson.JSON;
import com.own.entity.SysPermission;
import com.own.entity.SysUser;
import com.own.mapper.SysUserMapper;
import com.own.role.OwnUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类都是基于内存的 ，后期会改变为db,需要去数据库中查询
 * Created by smlz on 2019/12/25.
 */
@Component("userDetailsService")
@Slf4j
public class OwnUserDetailService implements UserDetailsService {


    //密码加密组件
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private ISysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        SysUser sysUser = sysUserMapper.findByUserName(userName);

        if (null == sysUser) {
            log.warn("根据用户名:{}查询用户信息为空", userName);
            throw new UsernameNotFoundException(userName);
        }

        List<SysPermission> sysPermissionList = sysPermissionService.findByUserId(sysUser.getId());

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sysPermissionList)) {
            for (SysPermission sysPermission : sysPermissionList) {
                authorityList.add(new SimpleGrantedAuthority(sysPermission.getUri()));
            }
        }

        OwnUser ownUser = new OwnUser(sysUser.getUsername(), passwordEncoder.encode(sysUser.getPassword()), authorityList);
        ownUser.setUserId(sysUser.getId());
        ownUser.setNickName(sysUser.getNickname());
        ownUser.setEmail(sysUser.getEmail());
        log.info("用户登陆成功:{}", JSON.toJSONString(ownUser));
        return ownUser;
    }
}

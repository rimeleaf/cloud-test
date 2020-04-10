package com.own.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MyabtisConfig
 * @Descripe： <br>
 * @package: com.own.config
 * @author: MECHREV
 * @date: 2020/4/8 19:33
 */
@Configuration
@MapperScan(basePackages = {"com.own.mapper"})
public class MybatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        paginationInterceptor.setLimit(500);
        return paginationInterceptor;


    }
}

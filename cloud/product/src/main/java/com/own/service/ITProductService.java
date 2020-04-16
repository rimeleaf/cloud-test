package com.own.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.own.entity.TProduct;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
public interface ITProductService extends IService<TProduct> {

    public boolean inventory(int id, int num) throws Exception;

}

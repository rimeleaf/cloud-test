package com.own.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.own.entity.TOrder;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
public interface ITOrderService extends IService<TOrder> {

    /**
     *
     * @param order
     * @return
     */
    boolean saveOrder(TOrder order) throws Exception;

    boolean updateOrder(int id) throws Exception;

}

package com.own.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.api.ProductFeignWithSentinelFallBackFactoryApi;
import com.own.entity.TOrder;
import com.own.mapper.TOrderMapper;
import com.own.service.ITOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Autowired
    private TOrderMapper mapper;
    @Autowired
    private ProductFeignWithSentinelFallBackFactoryApi productFeignApi;

    @GlobalTransactional(name = "create-order-inventory-product", rollbackFor = Exception.class)
    @Override
    public boolean saveOrder(TOrder order) throws Exception {
        boolean result = false;
//        order.setTotalPrice(1);
//       int m =  mapper.updateById(order);
        mapper.insert(order);
//        throw new Exception("xxxxxxx");
        result = productFeignApi.inventory(order.getProductId(), order.getNum());
        if (!result) {
            throw new Exception("创建订单-减库存失败");
        }
        return result;
    }

    @Override
    public boolean updateOrder(int id) throws Exception {
        TOrder order = new TOrder(3, 1, 200, 6000, 130000);
        mapper.updateById(order);
        return false;
    }
}

package com.own.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.entity.TProduct;
import com.own.mapper.TProductMapper;
import com.own.service.ITProductService;
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
public class TProductServiceImpl extends ServiceImpl<TProductMapper, TProduct> implements ITProductService {

    @Autowired
    private TProductMapper tProductMapper;

    @Override
    public boolean inventory(int id, int num) throws Exception {
        boolean result = false;
        TProduct product = tProductMapper.selectById(id);
        if (num > product.getNum()) {
            throw new Exception("产品" + id + "库存不足");
        } else {
            result = tProductMapper.inventory(id, num);
        }
        throw new Exception("测试错误");
//        return result;
    }
}

package com.own.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.own.entity.TProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
public interface TProductMapper extends BaseMapper<TProduct> {

    @Update("update t_product set num=num-#{num} where id=#{id}")
    public boolean inventory(@Param("id") int id, @Param("num") int num);

}

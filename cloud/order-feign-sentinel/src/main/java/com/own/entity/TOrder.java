package com.own.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class TOrder {

    @TableId(type = IdType.INPUT)
    private Integer id;
    private Integer productId;

    private Integer num;

    private Integer unitPrice;

    private Integer totalPrice;


}

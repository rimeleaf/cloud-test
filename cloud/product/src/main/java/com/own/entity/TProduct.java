package com.own.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@Accessors(chain = true)
//@TableName("t_product")
public class TProduct {

    @TableId
    private int id;
    private String name;

    private Integer num;

    private Integer unitPrice;


}

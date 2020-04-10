package com.own.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @className: BlockUtils
 * @Descripe： <br>
 * @package: com.own.exception
 * @author: MECHREV
 * @date: 2020/4/9 17:29
 */
public class BlockUtils {
  public static String blockHandlerTestHelloSentinelV3(BlockException e){
      return "v3 限流：" +e.getMessage();

  }
}

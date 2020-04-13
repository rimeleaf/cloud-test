package com.own.config;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * @className: OwnTimeBetweenConfig
 * @Descripe： <br>
 * @package: com.own.config
 * @author: MECHREV
 * @date: 2020/4/13 18:33
 */
@Data
public class OwnTimeBetweenConfig {
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
}

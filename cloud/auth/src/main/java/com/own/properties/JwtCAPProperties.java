package com.own.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @className: JwtProperties
 * @Descripe： <br>
 * @package: com.own.properties
 * @author: MECHREV
 * @date: 2020/4/8 20:02
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "own.jwt")
public class JwtCAPProperties {

    private String keyPairName;
    private String keyPairAlias;
    private String keyPairSecret;
    private String keyPairStoreSecret;
}

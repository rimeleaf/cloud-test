package com.own.indb;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * @className: OwnTokenEnhancer
 * @Descripe： <br>
 * @package: com.own.indb
 * @author: MECHREV
 * @date: 2020/4/8 20:15
 */
public class OwnTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        return oAuth2AccessToken;
    }
}

package com.own.config;

import com.own.indb.OwnTokenEnhancer;
import com.own.properties.JwtCAPProperties;
import com.own.service.OwnUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.Arrays;

/**
 * @className: OwnAuthorizationServer
 * @Descripe： 配置授权服务器
 * @package: com.own.server
 * @author: MECHREV
 * @date: 2020/4/8 19:43
 */
@EnableAuthorizationServer
public class OwnAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    JwtCAPProperties jwtCAPProperties;

    @Autowired
    OwnUserDetailService ownUserDetailService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //第三方客户端校验token需要带入 clientId 和clientSecret来校验
        security.checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("isAuthenticated()");//来获取我们的tokenKey需要带入clientId,clientSecretsecurity.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();

        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tulingTokenEnhancer(), jwtAccessTokenConverter()));

        endpoints.tokenStore(tokenStore()) //授权服务器颁发的token 怎么存储的
                .tokenEnhancer(tokenEnhancerChain)
                .userDetailsService(ownUserDetailService) //用户来获取token的时候需要 进行账号密码
                .authenticationManager(authenticationManager);
    }


    @Bean
    public ClientDetailsService clientDetails() {

        return new JdbcClientDetailsService(dataSource);

    }

    @Bean
    public TokenStore tokenStore() {

        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        return jwtAccessTokenConverter;
    }

    /**
     * jwt 密钥
     *
     * @return
     */
    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(jwtCAPProperties.getKeyPairName()),
                jwtCAPProperties.getKeyPairSecret().toCharArray());
        return keyStoreKeyFactory.getKeyPair(jwtCAPProperties.getKeyPairAlias(), jwtCAPProperties.getKeyPairStoreSecret().toCharArray());
    }

    @Bean
    public OwnTokenEnhancer tulingTokenEnhancer() {
        return new OwnTokenEnhancer();
    }


}

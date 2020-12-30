package com.cloud.study.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @description: 自定义Redisson
 * @author: dqq
 * @date: 2020/10/19 19:07
 */
@Configuration
public class MyRedissonConfig {


    @Value("${redis.url}")
    private String redisUrl;

    /**
     * 所有对redisson的使用都是通过RedissonClient来使用
     * @return
     * @throws IOException
     */
    @Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
        //1 创建配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+redisUrl+":6379");
        //2.根据Config创建出RedissonClient
        return Redisson.create(config);
    }
}

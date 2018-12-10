package com.fangfangxu.redis2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig2 {
    //
    @Autowired
    private RedisTemplate redisTemplate;

    @Bean(name="redis2")
    public RedisTemplate redisTemplateInit(@Qualifier("jedis") JedisConnectionFactory jedis) {
        redisTemplate.setConnectionFactory(jedis);
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    @Bean(name="jedis")
    JedisConnectionFactory jedisConnectionFactory(@Value("${spring.redis.password}") String password) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPassword(password);
        return jedisConnectionFactory;
    }

}

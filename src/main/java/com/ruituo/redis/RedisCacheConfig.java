package com.ruituo.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * description
 *
 * @author huijunjie
 * @date 2018-05-23 下午 4:29
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport{

    @Value("${spring.redis.database}")
    private String database;

    @Value("${spring.redis.host}")
    private String hostName;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.pool.max-idle}")
    private String maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private String minIdle;

    @Value("${spring.redis.pool.max-active}")
    private String maxTotal;

    @Value("${spring.redis.pool.max-wait}")
    private String maxWaitMillis;


    /**
     *TODO 注入连接参数
     *
     *@param
     *@return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory jedis = new JedisConnectionFactory();

        jedis.setHostName(hostName);
        jedis.setPort(Integer.parseInt(port));
        jedis.setDatabase(Integer.parseInt(database));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
        jedisPoolConfig.setMinIdle(Integer.parseInt(minIdle));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(maxWaitMillis));

        jedis.setPoolConfig(jedisPoolConfig);
        // 初始化连接pool
        jedis.afterPropertiesSet();
        RedisConnectionFactory factory = jedis;
        return factory;
    }

    /**
     *TODO redis模板操作
     *
     *@param factory:通过spring进行注入
     *@return
     */
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,String> redisTemplate=
                new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(factory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置value的序列化规则和 key的序列化规则
        //spring-data-redis中还提供了一个序列化的类专门针对string类型的序列化
        //new StringRedisSerializer()
        //但是遇到long类型的key会报转换异常
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     *TODO 缓存管理器
     *
     *@param redisTemplate
     *@return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

}

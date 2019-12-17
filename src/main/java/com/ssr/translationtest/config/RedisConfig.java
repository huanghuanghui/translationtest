package com.ssr.translationtest.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ssr.translationtest.util.RedisHandle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * @author hhh
 * @date 2019/1/25 17:01
 * @Despriction redis lettuce redisTemplate 配置
 */
@Configuration
public class RedisConfig {
  @Value("${spring.redis.host}")
  private String host;
  @Value("${spring.redis.password}")
  private String password;
  @Value("${spring.redis.port}")
  private Integer port;
  @Value("${spring.redis.database}")
  private Integer database;

  @Bean
  public <T> RedisTemplate<String, T> redisTemplateKeyString(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, T> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //去掉enableDefaultTyping配置，将其使用系统默认的Json解析方式解析
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  /**
   * 配置其他类型的redisTemplate
   ***/
  @Bean
  public RedisTemplate<Object, Object> redisTemplateKeyObject(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean(name = "ConnectionFactory")
  public LettuceConnectionFactory ConnectionFactory() {
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
    config.setDatabase(database);
    config.setHostName(host);
    config.setPort(port);
    config.setPassword(RedisPassword.of(password));
    return new LettuceConnectionFactory(config);
  }

  /**
   * 注入封装RedisTemplate
   */
  @Bean(name = "redisHandle")
  public RedisHandle redisUtil(RedisTemplate<String, Object> redisTemplate) {
    RedisHandle redisHandle = new RedisHandle();
    redisHandle.setRedisTemplate(redisTemplate);
    return redisHandle;
  }
}

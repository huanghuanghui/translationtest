package com.ssr.translationtest.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author hhh
 * @date 2019/12/17 9:51
 * @Despriction
 */
@Log4j2
public class RedisHandle {

  private static final long FRESH_TEMP_MAP_TIME = 1000 * 60;
  public static long sysClock = System.currentTimeMillis();
  private static final int REDIS_INCREASE = 1;

  /**
   * 默认失效时间   一小时
   */
  private static Long defaultExpireTime = 60*60L;
  private static Map<String, Map<String, String>> tempDictMap = new ConcurrentHashMap<>();
  private RedisTemplate<String, Object> redisTemplate;

  public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  /**
   * 指定缓存失效时间
   *
   * @param key  键
   * @param time 时间(秒)
   * @return
   */
  public boolean expire(String key, long time) {
    try {
      if (time > 0) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 使用清空本地缓存技巧
   * @param keyCode
   * @param redisKey
   * @return
   */
  private void getRedisKeyValue(String keyCode, String redisKey){
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    if ((System.currentTimeMillis() - sysClock) > FRESH_TEMP_MAP_TIME) {
      sysClock = System.currentTimeMillis();
      log.info("清空本地缓存 条数：{}", tempDictMap.size());
      tempDictMap.clear();
    }
  }

  /**
   * 根据key 获取过期时间
   *
   * @param key 键 不能为null
   * @return 时间(秒) 返回0代表为永久有效
   */
  public long getExpire(String key) {
    return redisTemplate.getExpire(key, TimeUnit.SECONDS);
  }

  /**
   * 判断key是否存在
   *
   * @param key 键
   * @return true 存在 false不存在
   */
  public boolean hasKey(String key) {
    try {
      return redisTemplate.hasKey(key);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 删除缓存
   *
   * @param key 可以传一个值 或多个
   */
  @SuppressWarnings("unchecked")
  public void del(String... key) {
    if (key != null && key.length > 0) {
      if (key.length == 1) {
        redisTemplate.delete(key[0]);
      } else {
        redisTemplate.delete(CollectionUtils.arrayToList(key));
      }
    }
  }

  /**
   * 普通缓存获取
   *
   * @param key 键
   * @return 值
   */
  public Object get(String key) {
    return key == null ? null : redisTemplate.opsForValue().get(key);
  }

  /**
   * 普通缓存放入
   *
   * @param key   键
   * @param value 值
   * @return true成功 false失败
   */
  public boolean set(String key, Object value) {
    try {
      redisTemplate.opsForValue().set(key, value);
      redisTemplate.expire(key, defaultExpireTime, TimeUnit.SECONDS);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 普通缓存放入并设置时间
   *
   * @param key   键
   * @param value 值
   * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
   * @return true成功 false 失败
   */
  public boolean set(String key, Object value, long time) {
    try {
      // 解决报错 non null key required
      if (time > 0 && key != null && value != null) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        redisTemplate.expire(key, defaultExpireTime, TimeUnit.SECONDS);
      } else if (key != null && value != null) {
        set(key, value);
      } else {
        log.error("non null key required_key=" + key + "|value=" + value);
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean hmSet(String key, Map<String, Object> map) {
    try {
      redisTemplate.opsForHash().putAll(key, map);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 恒定自增1
   *
   * @param key 键
   * @return
   */
  public long incr(String key) {
    return redisTemplate.opsForValue().increment(key, REDIS_INCREASE);
  }
}

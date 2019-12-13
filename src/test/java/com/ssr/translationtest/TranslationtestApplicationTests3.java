package com.ssr.translationtest;

import com.ssr.translationtest.entity.CallCdr;
import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hhh
 * @date 2019/11/22 15:43
 * @Despriction
 */
public class TranslationtestApplicationTests3 {
  public static void main(String args[]) {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://122.112.204.214:6379").setPassword("jnsaa@redis.master").setDatabase(2);
    RedissonClient redissonClient = Redisson.create(config);
    RBlockingQueue<CallCdr> blockingFairQueue = redissonClient.getBlockingQueue("delay_queue");
    RDelayedQueue<CallCdr> delayedQueue = redissonClient.getDelayedQueue(blockingFairQueue);
    while (true){
      CallCdr callCdr = null;
      try {
        callCdr = blockingFairQueue.take();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("订单取消时间："+new SimpleDateFormat("hh:mm:ss").format(new Date())+"==订单生成时间"+callCdr.getPutTime());

    }

  }
}

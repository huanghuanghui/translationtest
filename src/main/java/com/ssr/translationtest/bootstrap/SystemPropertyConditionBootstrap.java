package com.ssr.translationtest.bootstrap;

import com.ssr.translationtest.condition.ConditionalOnSystemProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author hhh
 * @date 2019/12/25 10:22
 * @Despriction
 */
@SpringBootApplication(scanBasePackages = "com.ssr.translationtest")
@Log4j2
public class SystemPropertyConditionBootstrap {

  /**
   * 使用条件进行装配 如果ConditionalOnSystemProperty 返回true在往下执行
   * @return
   */
  @Bean
  @ConditionalOnSystemProperty(name = "user.name",value = "黄煌辉")
  public String helloWorld(){
    return "helloWorld method execute";
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(SystemPropertyConditionBootstrap.class).run();
    String  s = context.getBean("helloWorld",String.class);
    log.info("获取HelloWorld Bean:{}"+s);
  }
}

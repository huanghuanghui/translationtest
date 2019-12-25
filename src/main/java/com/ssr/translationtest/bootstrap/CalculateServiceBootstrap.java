package com.ssr.translationtest.bootstrap;

import com.ssr.translationtest.service.CalculateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link com.ssr.translationtest.service.CalculateService} 引导类,使用profile 指定执行的配置类
 *
 * @author hhh
 * @date 2019/12/25 9:10
 * @Despriction
 */
@SpringBootApplication(scanBasePackages = "com.ssr.translationtest")
@Log4j2
public class CalculateServiceBootstrap {
  public static void main(String[] args) {
    ConfigurableApplicationContext context =
      new SpringApplicationBuilder(CalculateServiceBootstrap.class)
        .profiles("Java7")
        .run();
    CalculateService calculateService = context.getBean(CalculateService.class);
    Integer sum =calculateService.sum(1,2,3,4,5);
    log.info("CalculateService.sum(1...5):{}",sum);
  }
}

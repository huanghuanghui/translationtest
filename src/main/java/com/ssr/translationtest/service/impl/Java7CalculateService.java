package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.CalculateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2019/12/25 9:03
 * @Despriction
 */
@Profile("Java7")
@Service
@Log4j2
public class Java7CalculateService implements CalculateService {

  @Override
  public Integer sum(Integer... values) {
    log.info("Java7 方式实现");
    Integer sum  = 0;
    for (int i=0;i<values.length;i++){
      sum+=values[i];
    }
    return sum;
  }
}

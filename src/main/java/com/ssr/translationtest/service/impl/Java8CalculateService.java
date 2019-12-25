package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.CalculateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author hhh
 * @date 2019/12/25 9:03
 * @Despriction
 */
@Profile("Java8")
@Service
@Log4j2
public class Java8CalculateService implements CalculateService {

  @Override
  public Integer sum(Integer... values) {
    log.info("Java8 方式实现");
    return Arrays.stream(values).reduce(0,Integer::sum);
  }
}

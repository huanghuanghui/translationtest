package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.Strategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2019/11/13 10:14
 * @Despriction
 */
@Log4j2
@Service
public class AddStrategy implements Strategy {
  @Override
  public int calc(int num1, int num2) {
    log.info("调用AddStrategy calc");
    return num1+num2;
  }
}

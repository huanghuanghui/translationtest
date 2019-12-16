package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.Strategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2019/11/13 10:15
 * @Despriction
 */
@Log4j2
@Service
public class SubtractStrategy implements Strategy {
  @Override
  public int calc(int num1, int num2) {
    log.info("SubtractStrategy calc");
    return num1-num2;
  }
}

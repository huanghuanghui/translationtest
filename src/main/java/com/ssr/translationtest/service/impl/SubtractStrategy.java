package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.Strategy;

/**
 * @author hhh
 * @date 2019/11/13 10:15
 * @Despriction
 */
public class SubtractStrategy implements Strategy {
  @Override
  public int calc(int num1, int num2) {
    return num1-num2;
  }
}

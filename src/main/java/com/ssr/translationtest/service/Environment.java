package com.ssr.translationtest.service;

/**
 * @author hhh
 * @date 2019/11/13 10:19
 * @Despriction
 */
public class Environment {
  private Strategy strategy;

  public Environment(Strategy strategy) {
    this.strategy = strategy;
  }

  public int caculate(int num1,int num2){
    return strategy.calc(num1,num2);
  }
}

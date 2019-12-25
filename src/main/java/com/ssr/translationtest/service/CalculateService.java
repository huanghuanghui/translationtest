package com.ssr.translationtest.service;

/**
 * @author hhh
 * @date 2019/12/25 9:01
 * @Despriction 计算服务
 */
public interface CalculateService {
  /**
   * sum 求和
   * 从多个整数返回
   * @param values
   * @return
   */
  Integer sum(Integer...values);
}

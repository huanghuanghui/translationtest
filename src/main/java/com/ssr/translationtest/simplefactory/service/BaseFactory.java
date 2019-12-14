package com.ssr.translationtest.simplefactory.service;

/**
 * @author hhh
 * @date 2019/12/13 15:04
 * @Despriction
 */
public interface BaseFactory {
  HandleFactory getService(Integer type);

  HandleFactory getService2(Integer type);
}

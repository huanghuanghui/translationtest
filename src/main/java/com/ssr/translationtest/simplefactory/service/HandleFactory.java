package com.ssr.translationtest.simplefactory.service;

import com.ssr.translationtest.simplefactory.entity.Message;

/**
 * @author hhh
 * @date 2019/12/13 15:16
 * @Despriction
 */
public interface HandleFactory {
  /**
   *
   * @return
   */
  boolean handle(Message message);
}

package com.ssr.translationtest.simplefactory.service.impl;

import com.ssr.translationtest.simplefactory.entity.Message;
import com.ssr.translationtest.simplefactory.service.BaseFactory;
import com.ssr.translationtest.simplefactory.service.ExecuteFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2019/12/13 15:48
 * @Despriction
 */
@Service
public class ExecuteFactoryServiceImpl implements ExecuteFactoryService {
  @Autowired
  private BaseFactory baseFactory;

  @Override
  public void execute(Message message) {
    baseFactory.getService(message.getType()).handle(message);
  }
}

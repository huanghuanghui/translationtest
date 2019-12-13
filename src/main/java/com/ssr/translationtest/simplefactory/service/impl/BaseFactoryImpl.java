package com.ssr.translationtest.simplefactory.service.impl;

import com.ssr.translationtest.simplefactory.service.HandleFactory;
import com.ssr.translationtest.simplefactory.service.BaseFactory;
import com.ssr.translationtest.simplefactory.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2019/12/13 15:31
 * @Despriction
 */
@Service
public class BaseFactoryImpl implements BaseFactory {

  @Autowired
  private ConfigurableApplicationContext context;

  @Override
  public HandleFactory getService(Integer type) {
    return (HandleFactory)context.getBean(MessageUtil.HANDLE_FACTORY_MAP.get(type));
  }
}

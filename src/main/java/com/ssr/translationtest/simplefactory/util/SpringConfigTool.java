package com.ssr.translationtest.simplefactory.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2019/12/14 14:46
 * @Despriction 获取spring管理的bean
 */
@Component
public class SpringConfigTool {
  private static ApplicationContext context;// 声明一个静态变量保存

  public static ApplicationContext getContext() {
    return context;
  }

  public static Object getBean(String beanName) {
    return context.getBean(beanName);
  }

  public static <T> T getBean(Class<T> requireType) {
    return (T) context.getBean(requireType);
  }

  public void setApplicationContext(ApplicationContext context) throws BeansException {
    SpringConfigTool.context = context;
  }
}

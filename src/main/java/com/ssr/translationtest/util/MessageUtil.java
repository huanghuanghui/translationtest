package com.ssr.translationtest.util;

import com.ssr.translationtest.simplefactory.factory.OrderNoDispatchFactory;
import com.ssr.translationtest.simplefactory.factory.OrderSystemNewFactory;
import com.ssr.translationtest.simplefactory.factory.TaskDriverRemindFactory;

import java.util.HashMap;

/**
 * @author hhh
 * @date 2019/12/13 15:28
 * @Despriction
 */
public class MessageUtil {
  public static final HashMap<Integer, Class> HANDLE_FACTORY_MAP = new HashMap<Integer, Class>();
  /**
   * 订单未调度消息提醒
   */
  public final static Integer ORDER_NO_DISPATCH_NOTICE = 1;
  /**
   * 任务提醒
   */
  public final static Integer TASK_DRIVER_REMINDER = 2;
  /**
   * 直派委派商超时
   */
  public final static Integer ORDER_SYSTEM_NEW = 3;

  static {
    HANDLE_FACTORY_MAP.put(ORDER_NO_DISPATCH_NOTICE, OrderNoDispatchFactory.class);
    HANDLE_FACTORY_MAP.put(TASK_DRIVER_REMINDER, TaskDriverRemindFactory.class);
    HANDLE_FACTORY_MAP.put(ORDER_SYSTEM_NEW, OrderSystemNewFactory.class);
  }
}

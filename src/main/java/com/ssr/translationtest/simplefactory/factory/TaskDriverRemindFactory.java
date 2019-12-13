package com.ssr.translationtest.simplefactory.factory;

import com.ssr.translationtest.simplefactory.entity.Message;
import com.ssr.translationtest.simplefactory.service.HandleFactory;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2019/12/13 15:35
 * @Despriction
 */
@Service
public class TaskDriverRemindFactory implements HandleFactory {

  @Override
  public boolean handle(Message message) {
    System.out.println("此次消息类型为："+message.getMsg());
    return false;
  }
}

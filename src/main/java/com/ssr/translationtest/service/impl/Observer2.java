package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.Observer;
import com.ssr.translationtest.service.Subject;
import lombok.extern.log4j.Log4j2;

/**
 * @author hhh
 * @date 2019/11/13 14:47
 * @Despriction 观察者
 */
@Log4j2
public class Observer2 implements Observer {
  private Subject subject;

  public Observer2(Subject subject) {
    this.subject = subject;
    subject.registerObserver(this);
  }

  @Override
  public void update(String msg) {
    log.info("observer2 得到 3D 号码  -->{}, 我要赶紧告诉我舍友。",msg);
  }
}

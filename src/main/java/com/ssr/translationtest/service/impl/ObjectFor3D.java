package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.service.Observer;
import com.ssr.translationtest.service.Subject;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @author hhh
 * @date 2019/11/13 14:41
 * @Despriction
 */
public class ObjectFor3D implements Subject {

  private ArrayList<Observer> observers = new ArrayList();

  private String msg;

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    if (!CollectionUtils.isEmpty(observers)){
      observers.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {
    observers.forEach(e->e.update(msg));
  }

  /**
   * 主题通知消息
   * @param msg
   */
  public void setMsg(String msg){
    this.msg = msg;
    notifyObservers();
  }
}

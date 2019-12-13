package com.ssr.translationtest.controller;

import com.ssr.translationtest.entity.TxEntity;
import com.ssr.translationtest.service.Environment;
import com.ssr.translationtest.service.TxService;
import com.ssr.translationtest.service.impl.AddStrategy;
import com.ssr.translationtest.service.impl.SubtractStrategy;
import com.ssr.translationtest.simplefactory.entity.Message;
import com.ssr.translationtest.simplefactory.service.ExecuteFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhh
 * @date 2019/11/6 16:14
 * @Despriction
 */
@RestController
public class TestController {

  @Autowired
  private TxService txService;

  @Autowired
  private ExecuteFactoryService executeFactoryService;

  @PostMapping("/tx")
  public String tx(@RequestBody TxEntity tx){
    txService.insert(tx);
    return "插入成功!";
  }

  @GetMapping("/strategy")
  public int strategy(int num1,int num2){
    if (num1>num2){
      return new Environment(new SubtractStrategy()).caculate(num1,num2);
    }
    return new Environment(new AddStrategy()).caculate(num1,num2);
  }

  @PostMapping("/factory")
  public void strategy(@RequestBody Message message){
    executeFactoryService.execute(message);
  }
}

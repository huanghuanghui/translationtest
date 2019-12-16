package com.ssr.translationtest.controller;

import com.ssr.translationtest.entity.OrderEntity;
import com.ssr.translationtest.entity.TxEntity;
import com.ssr.translationtest.service.Environment;
import com.ssr.translationtest.service.TxService;
import com.ssr.translationtest.service.impl.AddStrategy;
import com.ssr.translationtest.service.impl.SubtractStrategy;
import com.ssr.translationtest.simplefactory.entity.Message;
import com.ssr.translationtest.simplefactory.service.ExecuteFactoryService;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
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
      return new Environment(new SubtractStrategy()).calculation(num1,num2);
    }
    return new Environment(new AddStrategy()).calculation(num1,num2);
  }

  @PostMapping("/factory")
  public void strategy(@RequestBody Message message){
    executeFactoryService.execute(message);
  }

  @PostMapping("/factory2")
  public void strategy2(@RequestBody Message message){
    executeFactoryService.execute2(message);
  }

  @PostMapping("/to-json")
  public void toJson(@RequestBody OrderEntity order){
    String json =order.toString();
    log.info(json);
    OrderEntity order2=(OrderEntity) order.toEntity(json);
    order2.setCompanyId(1037);
    log.info(order2.toString());
  }
}

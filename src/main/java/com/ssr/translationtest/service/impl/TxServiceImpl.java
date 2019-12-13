package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.entity.TxEntity;
import com.ssr.translationtest.mapper.TestMapper;
import com.ssr.translationtest.service.TxService;
import com.ssr.translationtest.service.TxService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hhh
 * @date 2019/11/6 16:29
 * @Despriction
 */
@Service
public class TxServiceImpl implements TxService {

  @Autowired
  private TestMapper testMapper;
  @Autowired
  private TxService2 txService2;

  @Override
//  @Transactional(propagation = Propagation.REQUIRED)
  public void insert(TxEntity tx) {
    testMapper.insertTx(tx);
    /**
     * 在默认的代理模式下，只有目标方法由外部调用，才能被 Spring 的事务拦截器拦截。在同一个类中的两个方法直接调用，
     * 是不会被 Spring 的事务拦截器拦截，就像上面的 save 方法直接调用了同一个类中的 method1方法，
     * method1 方法不会被 Spring 的事务拦截器拦截。可以使用 AspectJ 取代 Spring AOP 代理来解决这个问题。
     *
     * 为了解决这个问题，我们可以新建一个类。
     */
    //若次方法无事务，根据事务传播会将以下方法的事务纳入本事务中，若异常会与当前事务中的数据一起回滚
    txService2.insert(tx);//只有目标方法由外部调用，才能被 Spring 的事务拦截器拦截。
//    throw new RuntimeException();
  }


}

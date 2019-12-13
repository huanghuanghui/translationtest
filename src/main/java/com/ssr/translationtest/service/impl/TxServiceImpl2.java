package com.ssr.translationtest.service.impl;

import com.ssr.translationtest.entity.TxEntity;
import com.ssr.translationtest.mapper.TestMapper;
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
public class TxServiceImpl2 implements TxService2 {

  @Autowired
  private TestMapper testMapper;

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void insert(TxEntity tx) {
    testMapper.insertTx(tx);
    throw new RuntimeException();
  }

}

package com.ssr.translationtest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hhh
 * @date 2019/11/20 10:22
 * @Despriction
 */
@Data
public class TestEntity {
  private int id;
  private Boolean ac;

  public TestEntity(int id, Boolean ac) {
    this.id = id;
    this.ac = ac;
  }

  public static void main(String[] args) {
    TestEntity testEntity = new TestEntity(1,true);
    TestEntity testEntity2 = new TestEntity(1,false);
    List<TestEntity> list = new ArrayList();
    list.add(testEntity);
    list.add(testEntity2);

    List  l = list.stream().filter(e->!e.getAc()).collect(Collectors.toList());
    System.out.println(l);
  }
}

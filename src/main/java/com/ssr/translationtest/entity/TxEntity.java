package com.ssr.translationtest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hhh
 * @date 2019/11/6 16:22
 * @Despriction
 */
@Data
public class TxEntity implements Serializable {
  private Integer id;
  private String name;
  private Integer age;
  private Integer branchId;


  public TxEntity() {
  }


  public TxEntity(Integer id, String name, Integer age, Integer branchId) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.branchId = branchId;
  }
}

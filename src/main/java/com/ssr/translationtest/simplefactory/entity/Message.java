package com.ssr.translationtest.simplefactory.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hhh
 * @date 2019/12/13 15:26
 * @Despriction
 */
@Data
public class Message implements Serializable {
  private String msg;
  private Integer type;
}

package com.ssr.translationtest.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hhh
 * @date 2019/12/13 16:28
 * @Despriction
 */
@Getter
@Setter
public class OrderEntity extends Entity{
  private Long id;
  private String orderNumber;
  private String thirdPartyCaseNumber;
  private Integer companyId;
  private Integer customerId;
}

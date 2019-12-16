package com.ssr.translationtest.enmu;

import com.ssr.translationtest.service.RoleOperation;
import org.springframework.stereotype.Component;

/**
 * @author hhh
 * @date 2019/12/16 14:24
 * @Despriction 将不同角色的情况全部交由枚举类来做，定义一个不同角色有不同权限的枚举类
 */
@Component
public enum RoleEnum implements RoleOperation {
  ROLE_ROOT_ADMIN {
    @Override
    public String op() {
      return "ROLE_ROOT_ADMIN HAS ROLE_ROOT_ADMIN PERMISSION ";
    }
  },
  ROLE_ORDER_ADMIN {
    @Override
    public String op() {
      return "ROLE_ORDER_ADMIN HAS ROLE_ORDER_ADMIN PERMISSION";
    }
  },
  ROLE_NORMAL {
    @Override
    public String op() {
      return "ROLE_NORMAL HAS ROLE_NORMAL PERMISSION";
    }
  }
}

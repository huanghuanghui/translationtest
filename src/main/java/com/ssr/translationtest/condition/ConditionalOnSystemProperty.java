package com.ssr.translationtest.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hhh
 * @date 2019/12/25 9:45
 * @Despriction 系统属性条件判断
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional({OnSystemPropertyCondition.class})
public @interface ConditionalOnSystemProperty {
  /**
   * java系统属性名称
   * @return
   */
  String name() default "";

  /**
   * java系统属性值
   * @return
   */
  String value() default "";


}

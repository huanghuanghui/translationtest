package com.ssr.translationtest.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @author hhh
 * @date 2019/12/25 9:48
 * @Despriction 系统属性 条件判断
 */
public class OnSystemPropertyCondition implements Condition {
  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
    MultiValueMap<String, Object> multiValueMap = annotatedTypeMetadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
    String nameProperties =  String.valueOf(multiValueMap.get("name"));
    String valueProperties = String.valueOf(multiValueMap.get("value"));
    return "[黄煌辉]".equalsIgnoreCase(valueProperties);
  }
}

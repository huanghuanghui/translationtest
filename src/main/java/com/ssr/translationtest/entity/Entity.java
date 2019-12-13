package com.ssr.translationtest.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author hhh
 * @date 2019/12/13 16:19
 * @Despriction 基础实体类，所有的实体都应继承当前的基础实体类
 */
@SuppressWarnings("serial")
public class Entity<TEntity> implements Serializable {
  private static final long serialVersionUID = -6661962275751804866L;

  private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

  /**
   * 对象复制
   */
  public TEntity copy(Entity entity) {
    TEntity copy = (TEntity) gson.fromJson(gson.toJson(entity), this.getClass());
    return copy;
  }

  /**
   * 转换为json字符串
   */
  public String toJson() {
    return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(this);
  }

  public Entity() {
  }

  public TEntity toEntity(String json) {
    return (TEntity) gson.fromJson(json, this.getClass());
  }

  public TEntity toEntity(String json, Type type) {
    return (TEntity) gson.fromJson(json, type);
  }

  @Override
  public String toString() {
    return toJson();
  }

}

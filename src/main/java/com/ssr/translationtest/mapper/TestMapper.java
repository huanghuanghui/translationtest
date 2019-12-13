package com.ssr.translationtest.mapper;

import com.ssr.translationtest.entity.TxEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author hhh
 * @date 2019/11/6 16:17
 * @Despriction
 */
@Mapper
public interface TestMapper {
  @Insert("insert into tx (name, age, branch_id) values (#{param.name},#{param.age},#{param.branchId})")
  int insertTx(@Param("param") TxEntity tx);
}

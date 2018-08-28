package cn.learn.spitter.dao;

import cn.learn.spitter.pojo.po.Spittle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpittleDao {

  /**
   * 传入多个参数时，通过这样注解，直接在Mapper.xml里面使用
   */
  List<Spittle> listSpittles(@Param("max") long max, @Param("count") int count);
}

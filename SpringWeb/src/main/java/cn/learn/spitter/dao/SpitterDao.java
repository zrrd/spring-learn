package cn.learn.spitter.dao;

import cn.learn.spitter.pojo.po.Spitter;

public interface SpitterDao {

  void saveSpitter(Spitter spitter);

  /**
   * 单个参数就不用@Param.
   */
  Spitter getSpitterByUsername(String username);
}

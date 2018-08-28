package cn.learn.spitter.service;

import cn.learn.spitter.pojo.po.Spitter;


public interface SpitterService {

  void saveSpitter(Spitter spitter);

  Spitter getSpitterByUsername(String username);
}

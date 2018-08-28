package cn.learn.spitter.service.impl;

import cn.learn.spitter.dao.SpitterDao;
import cn.learn.spitter.pojo.po.Spitter;
import cn.learn.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpitterServiceImpl implements SpitterService {

  @Autowired
  SpitterDao spitterDao;

  @Override
  public void saveSpitter(Spitter spitter) {
    spitterDao.saveSpitter(spitter);
  }

  @Override
  public Spitter getSpitterByUsername(String username) {
    return spitterDao.getSpitterByUsername(username);
  }
}

package cn.learn.spitter.service.impl;

import cn.learn.spitter.dao.SpittleDao;
import cn.learn.spitter.pojo.po.Spittle;
import cn.learn.spitter.service.SpittleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpittleServiceImpl implements SpittleService {

  @Autowired
  SpittleDao spittleDao;

  @Override
  public List<Spittle> listSpittles(long max, int count) {
    return spittleDao.listSpittles(max, count);
  }

}

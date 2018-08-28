package cn.learn.spitter.service;

import cn.learn.spitter.pojo.po.Spittle;
import java.util.List;

public interface SpittleService {

  List<Spittle> listSpittles(long max, int count);
}

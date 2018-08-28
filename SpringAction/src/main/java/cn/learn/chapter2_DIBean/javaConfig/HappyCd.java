package cn.learn.chapter2_DIBean.javaConfig;

import cn.learn.chapter2_DIBean.autowired.CompactDisc;

public class HappyCd implements CompactDisc {

  @Override
  public void play() {
    System.out.println("happy");
  }
}

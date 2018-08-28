package cn.learn.chapter2_DIBean.autowired;

import org.springframework.stereotype.Component;

/**
 * @author syj
 */

@Component
public class PopularCd implements CompactDisc {

  @Override
  public void play() {
    String title = "Shape of You";
    String artist = "la la la";
    System.out.println(title + artist);
  }
}

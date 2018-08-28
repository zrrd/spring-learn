package cn.learn.chapter2_DIBean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {

  /**
   * Autowired 能注解在属性，构造函数，Setter方法上 反正只要有需要依赖注入的地方都能注解.
   */
  @Autowired
  private CompactDisc cd;

  @Autowired
  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public CompactDisc getCd() {
    return cd;
  }

  @Autowired
  public void setCd(CompactDisc cd) {
    this.cd = cd;
  }
}

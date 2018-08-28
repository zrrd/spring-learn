package cn.learn.chapter4_AOP.annotationAOP.parameter;

import org.springframework.stereotype.Component;

@Component
public class Add {

  /**
   * 只是一个简单的方法，单独用来测试
   */
  public Integer addNum(int num) {
    return num;
  }
}

package cn.learn.chapter4_AOP.annotationAOP;

import org.springframework.stereotype.Component;

@Component
public class Sing implements Performance {

  @Override
  public void performance() {
    System.out.println("la la la la");
  }
}

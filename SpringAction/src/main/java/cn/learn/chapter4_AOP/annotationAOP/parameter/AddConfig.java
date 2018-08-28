package cn.learn.chapter4_AOP.annotationAOP.parameter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.Target;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan
public class AddConfig {

  @Bean
  public CountNum countNum() {
    return new CountNum();
  }
}

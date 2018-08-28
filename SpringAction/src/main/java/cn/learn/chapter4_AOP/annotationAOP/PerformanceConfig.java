package cn.learn.chapter4_AOP.annotationAOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 注解了这条，才会认为Audience1是一个切面
 * 否则只是一个普通的bean
 * 如果是这样注解的话@EnableAspectJAutoProxy(proxyTargetClass = true)
 * 表明类使用cglib代理，基于类的代理 而不是jdk动态代理 基于接口的代理
 * 在测试类中就可以Sing sing
 * */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class PerformanceConfig {

  @Bean
  public Audience1 audience1() {
    return new Audience1();
  }
}

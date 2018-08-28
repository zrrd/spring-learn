package cn.learn.config;

import cn.learn.tools.aop.LoggerAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * EnableAspectJAutoProxy 开启aop.
 *
 * @author syj
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"cn.learn.tools.aop"})
public class ConcertConfig {

  @Bean
  public LoggerAdvice loggerAdvice() {
    return new LoggerAdvice();
  }
}

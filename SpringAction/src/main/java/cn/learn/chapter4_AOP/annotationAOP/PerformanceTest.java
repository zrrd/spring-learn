package cn.learn.chapter4_AOP.annotationAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformanceConfig.class)
public class PerformanceTest {

  /**
   * 这里如果是Sing sing 这样定义的话 会抛出Bean named 'sing' is expected to be of type
   * 'cn.learn.chapter4_AOP.annotationAOP.Sing' but was actually of type 'com.sun.proxy.$Proxy24 异常
   * AOP是基于java动态代理实现的 JDK动态代理只能对实现了接口的类生成代理，而不能针对类 所以要以接口定义类
   *
   * 或者配置文件启动动态代理这样配置 EnableAspectJAutoProxy(proxyTargetClass = true)
   */
  @Autowired
  Performance sing;

  @Test
  public void testSing() {
    sing.performance();
  }
}

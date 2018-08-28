package cn.learn.chapter2_DIBean.xmlConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:cn/learn/chapter2_DIBean/xmlConfig/CDPlayConfig2.xml"})
public class CDPlayTest {

  private ApplicationContext context = new ClassPathXmlApplicationContext(
      "cn/learn/chapter2_DIBean/xmlConfig/CDPlayConfig2.xml");

  @Test
  public void playCD() {
    CDPlayer cdPlayer = (CDPlayer) context.getBean("cdPlay1");
    cdPlayer.getCd().play();
  }
}

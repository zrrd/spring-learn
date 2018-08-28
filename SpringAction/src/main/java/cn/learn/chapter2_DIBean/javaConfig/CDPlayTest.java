package cn.learn.chapter2_DIBean.javaConfig;

import cn.learn.chapter2_DIBean.autowired.CDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayConfig1.class)
public class CDPlayTest {

  private ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayConfig1.class);

  @Test
  public void playCD() {
    CDPlayer cdPlayer = (CDPlayer) context.getBean("cdPlayer1");
    cdPlayer.getCd().play();
  }
}

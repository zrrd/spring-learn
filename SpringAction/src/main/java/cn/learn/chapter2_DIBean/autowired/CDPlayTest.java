package cn.learn.chapter2_DIBean.autowired;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 通过SpringJUnit4ClassRunner在测试的开始自动创建Spring上下文
 * 引入java类型的配置
 *  ContextConfiguration(classes = CDPlayerConfig.class)
 * 引入xml类型配置
 *  ContextConfiguration(locations = {"classpath:cn/learn/chapter2_DIBean/autowired/CDPlayConfig.xml"})
 * @author shaoyijiong
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:cn/learn/chapter2_DIBean/autowired/CDPlayConfig.xml"})
public class CDPlayTest {

  @Autowired
  private CDPlayer cdPlayer;

  @Test
  public void playCD() {
    cdPlayer.getCd().play();
  }
}

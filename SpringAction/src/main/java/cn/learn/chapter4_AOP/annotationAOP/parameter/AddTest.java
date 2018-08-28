package cn.learn.chapter4_AOP.annotationAOP.parameter;

import cn.learn.chapter4_AOP.annotationAOP.PerformanceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddConfig.class)
public class AddTest {

  @Autowired
  Add add;

  @Autowired
  CountNum countNum;

  @Test
  public void addTest() {
    add.addNum(1);
    add.addNum(2);
    add.addNum(3);
    System.out.println(countNum.getTotal());
  }
}

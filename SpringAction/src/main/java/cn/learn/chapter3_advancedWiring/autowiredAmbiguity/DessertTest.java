package cn.learn.chapter3_advancedWiring.autowiredAmbiguity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertConfig.class)
public class DessertTest {

  @Autowired
  TasteDessert tasteDessert;

  @Test
  public void mytest() {
    tasteDessert.taste();
  }
}

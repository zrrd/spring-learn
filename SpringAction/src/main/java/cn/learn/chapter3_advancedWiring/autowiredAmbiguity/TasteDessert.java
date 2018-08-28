package cn.learn.chapter3_advancedWiring.autowiredAmbiguity;

import cn.learn.chapter3_advancedWiring.autowiredAmbiguity.MyAnnotatioin.Cold;
import cn.learn.chapter3_advancedWiring.autowiredAmbiguity.MyAnnotatioin.Creamy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * .
 * @author shaoyijiong
 */

@Component
class TasteDessert {


  /**
   * 如果单独引入Dessert 而不做其它处理的话，因为有3个类实现了Dessert接口，而产生了歧义.
   * 通过id来表明要注入的是哪个bean 如果
   * Qualifier("cookies")
   * 或者在类上也注解@Qualifier 相同就注入(相当于byName的方式)
   * 通过自定义注解的方式
   * 更精确的识别要注入的bean
   */

  @Qualifier("ice")
  @Autowired
  @Cold
  @Creamy
  Dessert dessert;

  void taste() {
    System.out.println("taste  " + dessert.getClass().getSimpleName());
  }

}
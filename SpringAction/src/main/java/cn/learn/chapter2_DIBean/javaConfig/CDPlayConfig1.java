package cn.learn.chapter2_DIBean.javaConfig;

import cn.learn.chapter2_DIBean.autowired.CDPlayer;
import cn.learn.chapter2_DIBean.autowired.CompactDisc;
import cn.learn.chapter2_DIBean.autowired.PopularCd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayConfig1 {

  /**
   * 声明一个Bean 注意这里面向接口编程，返回的是一个具体的cd 声明bean的名字.
   */
  @Bean(name = "popularCd")
  public CompactDisc popularCd() {
    return new PopularCd();
  }

  /**
   * 这个和上面的方法都返回CompactDisc ，会使cdPlayer1()方法产生歧义，导致报错

   /**@Bean
   public CompactDisc randomCd() {
   int choice = new Random().nextInt(2);
   if (choice == 1) {
   return new PopularCd();
   } else {
   return new HappyCd();
   }
   }*/

  /**
   * 通过javaConfig实现注入
   */
  @Bean
  public CDPlayer cdPlayer() {
    // 这个不是通过调用注入，popularCd()上有@Bean注解，所以返回的CompactDisc
    // 都是由Spring容器产生，Spring容器默认单例，所以如果有其他也popularCd()话，
    // 返回同一个实例
    return new CDPlayer(popularCd());
  }

  /**
   * 请求一个CompactDisc作为参数，当Spring调用cdPlayer1()创建CDPlayBean的时候 .
   * 自动装配一个CompactDisc到方法中，Spring自己找CompactDisc类型的Bean
   */
  @Bean(name = "cdPlayer1")
  public CDPlayer cdPlayer1(CompactDisc compactDisc) {
    return new CDPlayer(compactDisc);
  }

  /**
   * 通过设值注入.
   */
  @Bean
  public CDPlayer cdPlayer2(CompactDisc compactDisc) {
    CDPlayer cdPlayer = new CDPlayer(compactDisc);
    cdPlayer.setCd(compactDisc);
    return cdPlayer;
  }
  /**
   * 还有其他各种产生bean的方法，构造器和setter只是两个样例
   * */
}

package cn.learn.chapter3_advancedWiring.runtimeDI;

import cn.learn.chapter2_DIBean.xmlConfig.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * 声明属性源.
 *
 * @author shaoyijiong
 */
@Configuration
@PropertySource("classpath:cn/learn/chapter3_advancedWiring/runtimeDI/app.properties")
public class ExpressiveConfig {

  @Autowired
  Environment env;

  @Bean
  public BlankDisc disc() {

    //检索属性值
    //1.return new BlankDisc(env.getProperty("disc.title"),env.getProperty("disc.disc.artist"));
    //在原来的基础上添加了默认值

    return new BlankDisc(env.getProperty("disc.title", "aa"),
        env.getProperty("disc.disc.artist", "bb"));
    /**
     * T getProperty(String key,Class<T> type)
     * T getProperty(String key,Class<T> type,T defaultValue)
     * 取其它类型的值
     * */
  }


  /**
   * 为了使用占位符 必须配置 PropertyPlaceholderConfigurer bean 或PropertySourcesPlaceholderConfigurer bean.
   */
  @Bean
  public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
  /**
   * 构造器可以改为
   * 这个得放在POJO中去
   * */
  /**           public BlankDisc(@Value("${disc.title}") String title,
   *                 @Value("${disc.artist}") String artist){
   *               this.title = title;
   *               this.artist = artist;
  }   **/
}

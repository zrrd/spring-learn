package cn.learn.chapter3_advancedWiring.beanScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * .
 * @author shaoyijong
 */
public class ShopingCartConfig {

  /**
   * <pre>
   * proxyMode属性被设置成 了ScopedProxyMode.INTERFACES，
   * 这表明这个代理要实现ShoppingCart接口， 并将调用委托给实现bean。
   * Spring这时并不会将实际的Cart bean注入到StoreService中，Spring 会注入一个Cart bean 的代理。
   * 这个代理会暴露与Cart相同的方法，所以认为他就是一个购物车。当StoreService调用Cart方法时，代理会对其进行赖解析，
   * 并调用委托给会话作用域内真正的Cart bean。
   * </pre>
   */
  @Bean
  @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
  public ShoppingCart shoppingCart() {
    return new ShoppingCart() {
    };
  }
}

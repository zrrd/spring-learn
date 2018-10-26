package cn.learn.chapter5_event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 点菜发布
 *
 * <p>
 * 该类实现ApplicationContextAware接口,得到ApplicationContext对象,使用该对象的publishEvent方法发布事件.
 * </p>
 *
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
@Component
public class OrderDishesPublisher {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;


  void publishEvent(ApplicationEvent event) {
    applicationEventPublisher.publishEvent(event);
  }
}

package cn.learn.chapter5_event;

import cn.learn.chapter5_event.dish.Dish;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

/**
 * 烧菜事件.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CookEvent extends ApplicationEvent {

  private Dish dish;

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public CookEvent(Object source) {
    super(source);
    dish = (Dish) source;
  }
}

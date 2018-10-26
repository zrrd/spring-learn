package cn.learn.chapter5_event.cooker;

import cn.learn.chapter5_event.dish.Dish;

/**
 * 厨师接口.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
public interface Cooker {

  /**
   * 厨师做菜.
   */
  void cookDish(Dish dish);
}

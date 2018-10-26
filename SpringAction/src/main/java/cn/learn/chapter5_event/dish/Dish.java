package cn.learn.chapter5_event.dish;

/**
 * 菜的抽象类.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
public interface Dish {

  /**
   * 得到菜的种类.
   *
   * @return 具体种类
   */
  String getDishType();

  /**
   * 得到菜的名字.
   *
   * @return 菜的名字
   */
  String getDishName();

  /**
   * 得到菜的价格.
   *
   * @return 菜的价格
   */
  Double getDishPrice();
}

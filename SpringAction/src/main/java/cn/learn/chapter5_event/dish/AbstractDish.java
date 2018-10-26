package cn.learn.chapter5_event.dish;

import lombok.Data;

/**
 * 菜的抽象类.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
@Data
public abstract class AbstractDish implements Dish {

  private String dishName;
  private Double dishPrice;

  AbstractDish(String dishName, Double dishPrice) {
    this.dishName = dishName;
    this.dishPrice = dishPrice;
  }

  /**
   * 获得菜的类型.
   *
   * @return 菜的类型
   */
  @Override
  public abstract String getDishType();

  @Override
  public String getDishName() {
    return dishName;
  }

  @Override
  public Double getDishPrice() {
    return dishPrice;
  }
}

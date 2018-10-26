package cn.learn.chapter5_event.dish;

/**
 * 川菜.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
public class ChuanDish extends AbstractDish {

  public ChuanDish(String dishName, Double dishPrice) {
    super(dishName, dishPrice);
  }

  @Override
  public String getDishType() {
    return "Chuan";
  }
}

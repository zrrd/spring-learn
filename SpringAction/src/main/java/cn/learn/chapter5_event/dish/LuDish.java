package cn.learn.chapter5_event.dish;

/**
 * 鲁菜.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
public class LuDish extends AbstractDish {

  public LuDish(String dishName, Double dishPrice) {
    super(dishName, dishPrice);
  }

  @Override
  public String getDishType() {
    return "Lu";
  }
}

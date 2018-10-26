package cn.learn.chapter5_event.dish;

/**
 * 粤菜.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
public class YueDish extends AbstractDish {

  public YueDish(String dishName, Double dishPrice) {
    super(dishName, dishPrice);
  }

  @Override
  public String getDishType() {
    return "Yue";
  }
}

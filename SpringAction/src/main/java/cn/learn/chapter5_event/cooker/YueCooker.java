package cn.learn.chapter5_event.cooker;

import cn.learn.chapter5_event.dish.Dish;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 川菜厨师.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
@Data
public class YueCooker implements Cooker {

  private String cookerName;

  private int cookNum;

  /**
   * 厨师做过的菜.
   */
  private List<Dish> dishes = new ArrayList<>();

  public YueCooker(String cookerName) {
    this.cookerName = cookerName;
  }

  @Override
  public void cookDish(Dish dish) {
    cookNum++;
    dishes.add(dish);
    System.out.println(cookerName + "做了一道粤菜" + dish.getDishName());
  }
}

package cn.learn.chapter5_event;

import cn.learn.chapter5_event.cooker.Cooker;
import cn.learn.chapter5_event.dish.Dish;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 专门的 点菜监听器.
 *
 * <p>
 * 也可以写通用的监听器 在onApplicationEvent中用 instanceof 匹配 可以继承ApplicationListener
 * 也可以在事件上添加EventListener注解来实现.
 * </p>
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
@Data
@Component
public class CookListener {

  private List<Cooker> cookers;

  public CookListener() {
    this.cookers = new ArrayList<>();
  }

  /**
   * EventListener注解 代替继承ApplicationListener  好处是可以自己取名字.
   */
  @EventListener
  public void listenCook(CookEvent event) {
    Dish dish = event.getDish();
    System.out.println("收到订单" + dish.getDishName() + dish.getDishPrice());
    //判断给哪个师傅做  每个师傅能做大菜品不一样
    String type = dish.getDishType();
    cookers.forEach(c -> {
      String className = c.getClass().getName();
      if (className.contains(type)) {
        c.cookDish(dish);
      }
    });
  }
}

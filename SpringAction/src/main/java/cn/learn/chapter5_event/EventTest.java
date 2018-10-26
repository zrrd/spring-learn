package cn.learn.chapter5_event;

import cn.learn.chapter5_event.cooker.ChuanCooker;
import cn.learn.chapter5_event.cooker.Cooker;
import cn.learn.chapter5_event.cooker.LuCooker;
import cn.learn.chapter5_event.cooker.YueCooker;
import cn.learn.chapter5_event.dish.ChuanDish;
import cn.learn.chapter5_event.dish.Dish;
import cn.learn.chapter5_event.dish.LuDish;
import cn.learn.chapter5_event.dish.YueDish;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类.
 *
 * @author 邵益炯
 * @date 2018/10/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EventConfig.class})
public class EventTest {

  @Autowired
  private CookListener cookListener;

  @Autowired
  private OrderDishesPublisher publisher;


  @Test
  public void test() {
    Cooker zhang = new ChuanCooker("张");
    Cooker wang = new YueCooker("王");
    Cooker li = new LuCooker("李");

    //将观察者对象几天监听器中
    cookListener.getCookers().addAll(ImmutableList.of(zhang, wang, li));

    //菜谱
    List<Dish> dishes = ImmutableList
        .of(new ChuanDish("麻婆豆腐", 10.3), new ChuanDish("宫爆鸡丁", 15.0), new YueDish("叉烧饭", 5.3),
            new YueDish("文昌鸡", 20.3), new LuDish("德州扒鸡", 30.0));

    //上面两步将菜馆建好了   接下来顾客可以进来点菜了
    int size = dishes.size();
    Random random = new Random();

    //顾客随机点三道菜
    for (int i = 0; i < 3; i++) {
      Dish dish = dishes.get(random.nextInt(size));
      publisher.publishEvent(new CookEvent(dish));
    }
  }
}

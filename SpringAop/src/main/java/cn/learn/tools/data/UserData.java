package cn.learn.tools.data;

import cn.learn.pojo.po.User;
import java.util.Arrays;
import java.util.List;


/**
 * @author syj 模拟数据库
 */
public class UserData {

  private static final User[] USERDATA = new User[]{new User("aa", "aa", "小a"),
      new User("bb", "bb", "小b")};
  private static final List<User> USERS = Arrays.asList(USERDATA);

  public static List<User> getUSERS() {
    return USERS;
  }

}

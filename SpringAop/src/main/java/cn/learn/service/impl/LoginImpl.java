package cn.learn.service.impl;

import cn.learn.pojo.po.User;
import cn.learn.service.Login;
import cn.learn.tools.data.UserData;
import org.springframework.stereotype.Service;

/**
 * .
 * @author syj
 */
@Service
public class LoginImpl implements Login {

  @Override
  public String login(String username, String password) {
    String infor = null;
    User u = new User(username, password, "");

    for (User user : UserData.getUSERS()) {
      if (user.equals(u)) {
        if (user.getPassword().equals(u.getPassword())) {
          infor = "欢迎用户" + user.getName();
        } else {
          infor = "用户密码不正确";
        }
        break;
      }
    }
    if (infor == null) {
      infor = "用户名不存在";
    }
    return infor;
  }
}

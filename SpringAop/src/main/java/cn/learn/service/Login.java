package cn.learn.service;


/**
 * .
 * @author syj
 */
public interface Login {

  /**
   * 用来模拟用户的登录情况
   *
   * @param username 用户名
   * @param password 用户密码
   * @return 用户登录信息
   */
  String login(String username, String password);
}

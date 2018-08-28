package cn.learn.controller;

import cn.learn.service.Login;
import cn.learn.tools.aop.RequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * .
 *
 * @author syj
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

  @Autowired
  private Login login;

  @RequestLog(logDescription = "登录页面")
  @RequestMapping(value = "/login")
  public String login() {
    return "/login";
  }

  @RequestLog(logDescription = "登录")
  @ResponseBody
  @RequestMapping(value = "/login/{username}/{password}")
  public String login(@PathVariable String username, @PathVariable String password) {
    return login.login(username, password);
  }
}

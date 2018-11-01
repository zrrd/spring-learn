package cn.learn.spitter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 * 相当于一个控制器切面. 控制器增强
 *
 * @author shaoyijiong
 */
@ControllerAdvice
public class AppWideExceptionHandler {

  /**
   * 异常处理器. 可以决定拦截哪些异常 ResponseStatus可以决定今日该异常后返回请求的状态码
   */
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public void a() {

  }

  /**
   * 用于数据绑定.
   */
  @InitBinder
  public void b(WebDataBinder binder) {
    //设置Collection最大长度
    binder.setAutoGrowCollectionLimit(1000);
    //name 属性不绑定
    binder.setDisallowedFields("name");

    //将1995-09-21String格式的日期转化为Date
    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
    binder.registerCustomEditor(Date.class, editor);
  }


  /*@InitBinder("user")
  public void init1(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("u.");
  }

  @InitBinder("stu")
  public void init2(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("s.");
  }

  @RequestMapping("/testBean")
  public ModelAndView testBean(User user, @ModelAttribute("stu") Student stu) {
    System.out.println(stu);
    System.out.println(user);
    String viewName = "success";
    ModelAndView modelAndView = new ModelAndView(viewName);
    modelAndView.addObject("user", user);
    modelAndView.addObject("student", stu);
    return modelAndView;
  }*/


  @ModelAttribute
  public void c() {

  }
}

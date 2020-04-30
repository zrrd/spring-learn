package cn.learn.spitter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 相当于一个控制器切面. 控制器增强 ControllerAdvice可以指定对哪些包下的controller起作用
 *
 * @author shaoyijiong
 */
@ControllerAdvice
public class AppWideExceptionHandler {

  /**
   * 异常处理器. 可以决定拦截哪些异常 ResponseStatus可以决定今日该异常后返回请求的状态码 ;
   * <p>还可以自己订定义返回类型 , 可以使用 @ResponseBody 注解 , 返回 json 请求</p>
   */
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public String exceptionHandler(Exception e) {
    e.printStackTrace();
    return "请求失败";
  }

  /**
   * 用于数据绑定.
   */
  @InitBinder
  public void binder(WebDataBinder binder) {
    //设置Collection最大长度
    binder.setAutoGrowCollectionLimit(1000);
    //name 属性不绑定
    binder.setDisallowedFields("name");

    //将1995-09-21String格式的日期转化为Date
    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
    binder.registerCustomEditor(Date.class, editor);
  }


  /**
   * 对于每一个请求参数名为user的都加一个前缀u.
   */
  @InitBinder("user")
  public void init1(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("u.");
  }

  @InitBinder("stu")
  public void init2(WebDataBinder binder) {
    binder.setFieldDefaultPrefix("s.");
  }

/*  @RequestMapping("/testBean")
  public ModelAndView testBean(User user, @ModelAttribute("stu") Student stu) {
    System.out.println(stu);
    System.out.println(user);
    String viewName = "success";
    ModelAndView modelAndView = new ModelAndView(viewName);
    modelAndView.addObject("user", user);
    modelAndView.addObject("student", stu);
    return modelAndView;
  }*/

  private ConcurrentHashMap<String, LongAdder> counterMap = new ConcurrentHashMap<>();

  /**
   * <p>把值绑定到Model中，使全局@RequestMapping可以获取到该值</p>
   * <p>每个返回中都有 counter 与 uri 属性 记录了每个路径的访问次数</p>
   */
  @ModelAttribute
  public void modelAttribute(HttpServletRequest request, Model model) {
    String requestURI = request.getRequestURI();
    //counter increment for each access to a particular uri
    counterMap.computeIfAbsent(requestURI, key -> new LongAdder())
        .increment();
    //populating counter in the model
    model.addAttribute("counter", counterMap.get(requestURI).sum());
    //populating request URI in the model
    model.addAttribute("uri", requestURI);
  }
}

package cn.learn.chapter4_AOP.annotationAOP.parameter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

@Aspect
public class CountNum {

  private Integer total = 0;

  /**
   * 参数类型      指定参数
   */
  @Pointcut("execution(* cn.learn.chapter4_AOP.annotationAOP.parameter.Add.addNum(int ))"
      + "&& args(num)")
  public void addNum(int num) {
  }

  @Before("addNum(num)")
  public void count(int num) {
    System.out.println(num);
    total = total + num;
  }

  public Integer getTotal() {
    return total;
  }
}

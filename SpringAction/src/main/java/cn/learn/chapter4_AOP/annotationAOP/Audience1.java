package cn.learn.chapter4_AOP.annotationAOP;

import org.aspectj.lang.annotation.*;

/**
 * @Pointcut
 */
@Aspect
public class Audience1 {

  /**
   * 在Audience类中  相同的切点重复了4次  把重复的东西抽出来
   */
  @Pointcut("execution(* cn.learn.chapter4_AOP.annotationAOP.Performance.performance(..))")
  /**
   * 作为一个标识
   * 供@Pointcut注解依附
   * */
  public void performance() {
  }

  @Before("performance()")
  public void silenceCellPhone() {
    System.out.println("Silencing call phones");
  }

  @Before("performance()")
  public void takeSeats() {
    System.out.println("Taking seats");
  }

  @AfterReturning("performance()")
  public void applause() {
    System.out.println("Clap Clap Clap");
  }

  @AfterThrowing("performance()")
  public void demandRefund() {
    System.out.println("Demand a refund");
  }
}

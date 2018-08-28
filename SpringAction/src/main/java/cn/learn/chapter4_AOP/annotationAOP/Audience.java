package cn.learn.chapter4_AOP.annotationAOP;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 表明该类是个切面
 *
 * @author shaoyijiong
 */
@Aspect
public class Audience {
  /**
   * Spring 本身只支持基于xml配置的AOP 如果要基于注解配置的话.
   * 需要引入aspectj包
   * 在执行performance()前
   * 除了execution() 还有很多限定符 看书上有
   * 返回任意类型      方法   使用任意参数
   */
  @Before("execution(* cn.learn.chapter4_AOP.annotationAOP.Performance.performance(..))")
  public void silenceCellPhone() {
    System.out.println("Silencing call phones");
  }

  @Before("execution(* cn.learn.chapter4_AOP.annotationAOP.Performance.performance(..)))")
  public void takeSeats() {
    System.out.println("Taking seats");
  }

  @AfterReturning("execution(* cn.learn.chapter4_AOP.annotationAOP.Performance.performance(..)))")
  public void applause() {
    System.out.println("Clap Clap Clap");
  }

  @AfterThrowing("execution(* cn.learn.chapter4_AOP.annotationAOP.Performance.performance(..)))")
  public void demandRefund() {
    System.out.println("Demand a refund");
  }
}

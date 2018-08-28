package cn.learn.chapter4_AOP.annotationAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class Audience2 {

  @Pointcut("execution(* cn.learn.chapter4_AOP.annotationAOP.Performance.performance(..))")
  public void performance() {
  }

  @Around("performance()")
  public void watchPerformance(ProceedingJoinPoint jp) {
    try {
      System.out.println("Silencing call phones");
      System.out.println("Taking seats");
      /**
       * 必须要调用这个方法，否则会阻塞
       * */
      jp.proceed();
      System.out.println("Clap Clap Clap");
    } catch (Exception e) {
      System.out.println("Demand a refund");
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }
}

package cn.learn.chapter4_AOP.xmlAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public class Audience2 {

  public void watchPerformance(ProceedingJoinPoint jp) {
    try {
      System.out.println("Silencing call phones");
      System.out.println("Taking seats");
      jp.proceed();
      System.out.println("Clap Clap Clap");
    } catch (Exception e) {
      System.out.println("Demand a refund");
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
  }
}

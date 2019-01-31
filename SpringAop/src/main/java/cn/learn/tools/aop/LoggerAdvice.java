package cn.learn.tools.aop;

import com.alibaba.fastjson.JSON;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author shaoyijong
 */

@Component
@Aspect
public class LoggerAdvice {

  private static Logger logger = Logger.getLogger(LoggerAdvice.class);
  /**
   * arg() @arg() 指定参数
   * execution() 执行方法
   * this()
   * target @target 指定对象 指定注解
   * within() @within() 匹配指定类型  concert.* 意思是concert下的任意类
   *  @annotation 有指定注解
   * */

  /**
   * 下面before的意思是TestController类下的有requestLog注解的方法 joinPoint 连接点 这里是指Aop下的方法 获得该切点的所有参数并且打印
   */


  @Before("within(cn.learn.controller.*) && @annotation(requestLog)")
  public void addBeforeLogger(JoinPoint joinPoint, RequestLog requestLog) {
    LocalDateTime now = LocalDateTime.now();
    System.out.println("aa");
    logger.info(now.toString() + "执行[" + requestLog.logDescription() + "]开始");
    logger.info(joinPoint.getSignature().toString());
    logger.info(parseParams(joinPoint.getArgs()));

  }

  @AfterReturning(pointcut = "within(cn.learn.controller.*) && @annotation(requestLog)", returning = "returnValue")
  public void afterLogger(JoinPoint joinPoint, RequestLog requestLog, Object returnValue) {
    LocalDateTime now = LocalDateTime.now();
    logger.info(now.toString() + "执行[" + requestLog.logDescription() + "]结束");
    logger.info(joinPoint.getSignature().toString());
    logger.info("返回数据为" + JSON.toJSON(returnValue));
  }

  @AfterThrowing(pointcut = "within(cn.learn.controller.*) && @annotation(requestLog)", throwing = "ex")
  public void addAfterThrowingLogger(JoinPoint joinPoint, RequestLog requestLog, Exception ex) {
    LocalDateTime now = LocalDateTime.now();
    logger.error(now.toString() + "执行 [" + requestLog.logDescription() + "] 异常", ex);
  }

  private String parseParams(Object[] params) {
    if (null == params || params.length <= 0) {
      return "";
    }
    StringBuilder param = new StringBuilder("传入参数 # 个:[ ");
    int i = 0;
    for (Object obj : params) {
      i++;
      if (i == 1) {
        param.append(obj.toString());
        continue;
      }
      param.append(" ,").append(obj.toString());
    }
    return param.append(" ]").toString().replace("#", String.valueOf(i));
  }

}

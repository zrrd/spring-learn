package cn.learn.chapter3_advancedWiring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {

  /**
   * 判断是否存在名为magic的环境属性 ConditionContext接口有很多别的方法.
   */
  @Override
  public boolean matches(ConditionContext conditionContext,
      AnnotatedTypeMetadata annotatedTypeMetadata) {
    Environment environment = conditionContext.getEnvironment();
    return environment.containsProperty("magic");
  }
}

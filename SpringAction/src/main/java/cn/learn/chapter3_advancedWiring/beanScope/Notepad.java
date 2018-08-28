package cn.learn.chapter3_advancedWiring.beanScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 默认使用单例模型
 * 单例（Singleton） ： 在整个应用中， 只创建bean的一个实例。  默认spring容器都是单例
 * 原型（Prototype） ： 每次注入或者通过Spring应用上下文获取的时候， 都会创建一个新的bean实例。
 * 会话（Session） ： 在Web应用中， 为每个会话创建一个bean实例。
 * 请求（Rquest） ： 在Web应用中， 为每个请求创建一个bean实例。
 * ConfigurableBeanFactory.SCOPE_PROTOTYPE  = "prototype"
 * 这样做可以防止拼写错误
 * 也可以声明在javaConfig中
 *
 * @author shaoyijiong
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Notepad {
}

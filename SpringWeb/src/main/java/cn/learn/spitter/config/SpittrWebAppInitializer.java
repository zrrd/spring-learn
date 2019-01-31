package cn.learn.spitter.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 如果你坚持要了解更多细节的话， 那就看这里吧。 在Servlet 3.0环境中， 容器会在类路径中查找实 现javax.servlet.ServletContainerInitializer接口的类，
 * 如果能发现的话， 就会用它来配置Servlet容器。 Spring提供了这个接口的实现， 名为SpringServletContainerInitializer， 这个类反过来又会查找实
 * 现WebApplicationInitializer的类并将配置的任务交给它们来完成。 Spring 3.2引入了一个便利 的WebApplicationInitializer基础实现，
 * 也就是AbstractAnnotationConfigDispatcherServletInitializer。 因为我们 的Spittr-WebAppInitializer扩展了AbstractAnnotationConfig
 * DispatcherServlet-Initializer（同时也就实现 了WebApplicationInitializer） ， 因此当部署到Servlet 3.0容器中的时候，
 * 容器会自动发现它， 并用它来配置Servlet上下文。 尽管它的名字很长， 但是AbstractAnnotationConfigDispatcherServlet-Initializer使用起来很简便。
 * 在程序清单5.1 中， SpittrWebAppInitializer重写了三个方法。 第一个方法是getServletMappings()，
 * 它会将一个或多个路径映射到DispatcherServlet上。 在本例中， 它映射的是“/”， 这表示它会 是应用的默认Servlet。 它会处理进入应用的所有请求。 为了理解其他的两个方法，
 * 我们首先要理解DispatcherServlet和一个Servlet监听器（也就是ContextLoaderListener） 的关系
 */

/**
 * 相当于一个web应用的上下文配置 web.xml
 *
 * @author syj
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /**
   * 返回Servlet监听器，ContextLoaderListener 用来加载应用中的其他bean 相当于一个applicationContext.xml配置
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[]{RootConfig.class};
  }

  /**
   * 返回DispatcherServlet用来加载web组件的bean 控制器(controller)   视图解析器     处理器映射 相当于dispatcher-servlet.xml
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[]{WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    //映射的是“/”， 这表示它会
    //是应用的默认Servlet。 它会处理进入应用的所有请求

    return new String[]{"/"};
  }


  /**
   * 给DispatcherServlet添加额外配置
   */
  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement("E:\\tmp", 4194304, 8388608, 0));
  }


  /**
   * 给web应用添加过滤器，处理乱码问题 编码过滤器
   */
  @Override
  protected Filter[] getServletFilters() {
    return new Filter[]{new CharacterEncodingFilter("UTF-8")};
  }

}

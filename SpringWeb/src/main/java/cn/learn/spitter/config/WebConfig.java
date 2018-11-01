package cn.learn.spitter.config;


import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 最简单但是可用的Spring Mvc配置 处理器，控制器 controller 视图解析器 有很多类型的视图解析器 相当于dispatcher-servlet.xml
 *
 * @author shaoyijiong
 */
@Configuration
@EnableWebMvc
@ComponentScan("cn.learn.spitter.controller")
public class WebConfig extends WebMvcConfigurationSupport {

  /**
   * 配置JSP视图解析器.
   */
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();

    // 返回home 在返回视图后解析为
    // /WEB-INF/views/home.jsp

    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    resolver.setExposeContextBeansAsAttributes(true);

    //多个视图解析器的时候配置优先级 0 最高
    //将试图解析为JstlView
    //resolver.setViewClass(JstlView.class);

    return resolver;
  }

  /**
   * 配置静态资源的处理.
   */
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    //对静态资源的请求转发到servlet容器中的默认servlet上
    //而不是使用DispatcherServlet本身来处理该请求
    configurer.enable();
  }

  /**
   * 校验相关.
   */
  @Bean("messageSource")
  public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    /**
     * 引入外部的错误信息 resource下
     * */
    messageSource.setBasenames("ValidationMessages");
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setCacheSeconds(120);
    return messageSource;
  }

  @Bean("validator")
  public LocalValidatorFactoryBean localValidatorFactoryBean() {
    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
    localValidatorFactoryBean.setValidationMessageSource(reloadableResourceBundleMessageSource());
    return localValidatorFactoryBean;
  }

  /**
   * 配置Thymeleaf 类似于jsp
   * 能直接在浏览器内渲染效果
   * */
/*    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public TemplateResolver templateResolver(){
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }*/

  /**
   * multipart解析器处理文件上传.
   */
  @Bean
  public MultipartResolver multipartResolver() {
    //StandardServletMultipartResolver基于servlet3
    return new StandardServletMultipartResolver();
  }

}

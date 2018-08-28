package cn.learn.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * .
 * @author syj
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "cn.learn.controller")
@Import(ConcertConfig.class)
public class WebConfig {

  @Bean
  public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setCharacterEncoding("UTF-8");
    viewResolver.setCache(false);
    viewResolver.setTemplateEngine(templateEngine);
    return viewResolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    return templateEngine;
  }

  @Bean
  public TemplateResolver templateResolver() {
    TemplateResolver templateResolver = new ServletContextTemplateResolver();
    templateResolver.setPrefix("/WEB-INF/templates");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML5");
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setCacheable(false);
    return templateResolver;
  }

  /**
   * 校验相关
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


  @Bean
  public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
    RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
    StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
    List<MediaType> mediaTypes = new ArrayList<>();
    Charset charset = Charset.forName("UTF-8");
    mediaTypes.add(new MediaType("text", "plain", charset));
    mediaTypes.add(new MediaType("text", "html", charset));
    stringHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    messageConverters.add(stringHttpMessageConverter);
    requestMappingHandlerAdapter.setMessageConverters(messageConverters);
    return requestMappingHandlerAdapter;
  }
}

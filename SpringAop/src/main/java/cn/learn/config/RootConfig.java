package cn.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * .
 * @author syj
 */
@ComponentScan(basePackages = {"cn.learn"}, excludeFilters =
    {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class,
        EnableAspectJAutoProxy.class})})
@Configuration
@Import(ConcertConfig.class)
public class RootConfig {

}

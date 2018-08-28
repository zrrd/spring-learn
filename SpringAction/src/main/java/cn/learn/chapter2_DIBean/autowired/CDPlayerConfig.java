package cn.learn.chapter2_DIBean.autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration 通过java程序配置的方式 标志这是一个用来配置的类.
 *
 * ComponentScan 默认扫描与配置类相同的包以及下面的子包，
 * 查找带有@Component注解的类
 * 在Spring容器内创建一个类
 * 用@ComponentScan("other package")来扫描别的包
 * 用@ComponentScan(basePackages={"package1","package2"})来扫描多个包
 * 用@ComponentScan(basePackageClasses={A.class,B.class})来扫描A,B两个类所在的包
 *
 * @author shaoyijiong
 */

@Configuration
@ComponentScan
public class CDPlayerConfig {

}

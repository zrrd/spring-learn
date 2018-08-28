package cn.learn.chapter2_DIBean.mixJavaAndXml;


import cn.learn.chapter2_DIBean.javaConfig.CDPlayConfig1;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * 引入了其它基于java代码的bean配置 多个用,分开.
 * 引入基于xml的bean配置
 *
 * @author shaoyijiong
 * */
@Configuration
@Import(CDPlayConfig1.class)
@ImportResource("classpath:cn/learn/chapter2_DIBean/xmlConfig/CDPlayConfig2.xml")
public class CDPlayerConfig3 {
}

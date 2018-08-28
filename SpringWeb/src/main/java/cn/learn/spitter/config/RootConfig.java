package cn.learn.spitter.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 相当于原来application.xml的作用 整合中间件，添加基础bean excludeFilters：指定不适合组件扫描的类型。
 *
 * @author shaoyijiong
 */
@Configuration
@ComponentScan(basePackages = {"cn.learn.spitter"}, excludeFilters =
    {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

  /**
   * c3p0数据库连接池.
   */
  @Bean("dataSource")
  public DataSource dataSources() {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    try {
      //基本配置
      dataSource.setDriverClass("com.mysql.jdbc.Driver");
      dataSource.setJdbcUrl(
          "jdbc:mysql://localhost:3306/spittle?useUnicode=true&characterEncoding=UTF-8");
      dataSource.setUser("root");
      dataSource.setPassword("1234");

      //额外配置
      dataSource.setMinPoolSize(5);
      dataSource.setMaxPoolSize(30);
      dataSource.setInitialPoolSize(10);
      dataSource.setMaxIdleTime(60);
      dataSource.setAcquireIncrement(5);
      dataSource.setMaxStatements(0);
      dataSource.setIdleConnectionTestPeriod(60);
      dataSource.setAcquireRetryAttempts(30);
      dataSource.setBreakAfterAcquireFailure(true);
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    return dataSource;
  }

  /**
   * 配置mybaits工厂 spring和MyBatis完美整合，不需要mybatis的配置映射文件.
   */
  @Bean("sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSources());
    //获取xxxMapper.xml资源
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource[] mapperResources = resolver
        .getResources("classpath*:cn/learn/spitter/**/*Mapper.xml");
    sqlSessionFactoryBean.setMapperLocations(mapperResources);

    //为该包下的类取别名，在xxxMapper.xml上可以直接使用，不用加前缀
    sqlSessionFactoryBean.setTypeAliasesPackage("cn.learn.spitter.pojo.po");
    return sqlSessionFactoryBean.getObject();
  }

  /**
   * DAO接口所在包名，Spring会自动查找其下的类 Mapper动态代理开发   扫描.
   */
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer msc = new MapperScannerConfigurer();
    msc.setBasePackage("cn.learn.spitter.dao");
    msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
    return msc;
  }


}

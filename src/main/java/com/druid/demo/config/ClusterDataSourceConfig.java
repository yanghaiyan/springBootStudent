package com.druid.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {

  static final String PACKAGE = "com.druid.demo.dao";
  static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

  @Value("${cluster.datasource.url}")
  private String url;

  @Value("${cluster.datasource.username}")
  private String username;

  @Value("${cluster.datasource.password}")
  private String password;

  @Value("${cluster.datasource.driverClassName}")
  private String driverClass;

  // 和MasterDataSourceConfig一样，这里略

  @Bean(name = "clusterDataSource")
  public DataSource clusterDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setDriverClassName(driverClass);

    // 和MasterDataSourceConfig一样，这里略 ...
    return dataSource;
  }

  @Bean(name = "clusterTransactionManager")
  public DataSourceTransactionManager clusterTransactionManager() {
    return new DataSourceTransactionManager(clusterDataSource());
  }

  @Bean(name = "clusterSqlSessionFactory")
  public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
      throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(clusterDataSource);
    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
    //分页插件
    Interceptor interceptor = new PageInterceptor();
    Properties properties = new Properties();
    //数据库
    properties.setProperty("helperDialect", "mysql");
    //是否将参数offset作为PageNum使用
    properties.setProperty("offsetAsPageNum", "true");
    //是否进行count查询
    properties.setProperty("rowBoundsWithCount", "true");
    //是否分页合理化
    properties.setProperty("reasonable", "false");
    interceptor.setProperties(properties);
    sessionFactory.setPlugins(new Interceptor[] {interceptor});
    return sessionFactory.getObject();
  }
}

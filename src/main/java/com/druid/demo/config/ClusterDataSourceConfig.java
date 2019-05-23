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

  // ��MasterDataSourceConfigһ����������

  @Bean(name = "clusterDataSource")
  public DataSource clusterDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setDriverClassName(driverClass);

    // ��MasterDataSourceConfigһ���������� ...
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
    //��ҳ���
    Interceptor interceptor = new PageInterceptor();
    Properties properties = new Properties();
    //���ݿ�
    properties.setProperty("helperDialect", "mysql");
    //�Ƿ񽫲���offset��ΪPageNumʹ��
    properties.setProperty("offsetAsPageNum", "true");
    //�Ƿ����count��ѯ
    properties.setProperty("rowBoundsWithCount", "true");
    //�Ƿ��ҳ����
    properties.setProperty("reasonable", "false");
    interceptor.setProperties(properties);
    sessionFactory.setPlugins(new Interceptor[] {interceptor});
    return sessionFactory.getObject();
  }
}

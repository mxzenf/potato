package com.yx.potato.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = "com.yx.potato.mapper.sys.*", sqlSessionFactoryRef = "sysSqlSessionFactory")
public class DataSourceSysConfig {
  @Value("${datasource.sysdb.url}")
  private String url;
  
  @Value("${datasource.sysdb.username}")
  private String user;

  @Value("${datasource.sysdb.password}")
  private String password;

  @Value("${datasource.sysdb.driverClassName}")
  private String driverClass;
  
  @Bean(name = "sysDataSource")
  @Primary
  public DataSource sysDataSource(){
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(driverClass);
    dataSource.setUrl(url);
    dataSource.setUsername(user);
    dataSource.setPassword(password);
    return dataSource;
  }
  

  @Bean(name = "sysTransactionManager")
  @Primary
  public DataSourceTransactionManager masterTransactionManager() {
      return new DataSourceTransactionManager(sysDataSource());
  }
  
  @Bean(name = "sysSqlSessionFactory")
  @Primary
  public SqlSessionFactory masterSqlSessionFactory(@Qualifier("sysDataSource") DataSource masterDataSource)
          throws Exception {
      final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      sessionFactory.setDataSource(masterDataSource);
      return sessionFactory.getObject();
  }
}

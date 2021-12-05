package com.xian.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Xian
 */
@Configuration
@ComponentScan("com.xian.service")
@MapperScan(basePackages = "com.xian.mapper")
@PropertySource("classpath:hikari.properties")
public class SpringConfig {
    @Autowired
    private Environment env;
    @Bean
    @Scope
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("hikari.driver-class-name"));
        config.setJdbcUrl(env.getProperty("hikari.jdbc-url"));
        config.setUsername(env.getProperty("hikari.username"));
        config.setPassword(env.getProperty("hikari.password"));
        config.setMaxLifetime(Long.parseLong(env.getProperty("hikari.max-lifetime")));
        config.setPoolName(env.getProperty("hikari.pool-name"));
        config.setAutoCommit(Boolean.parseBoolean(env.getProperty("hikari.auto-commit")));
        config.setMaximumPoolSize(Integer.parseInt(env.getProperty("hikari.maximum-pool-size")));
        config.setIdleTimeout(Integer.parseInt(env.getProperty("hikari.idle-timeout")));
        config.setMinimumIdle(Integer.parseInt(env.getProperty("hikari.minimum-idle")));
        config.setConnectionTestQuery(env.getProperty("hikari.connection-test-query"));
        config.setConnectionTimeout(Integer.parseInt(env.getProperty("hikari.connection-timeout")));
        return new HikariDataSource(config);
    }

    @Bean
    @Scope
    public SqlSessionFactory sessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Scope
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }


}

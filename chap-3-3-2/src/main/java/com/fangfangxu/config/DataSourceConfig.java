package com.fangfangxu.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("oneDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource getTheOneDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean("twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource getTheTwoDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean("oneJdbcTemplate")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDataSource") DataSource datasource){
      return new JdbcTemplate(datasource);

    }
    @Bean("twoJdbcTemplate")
    public JdbcTemplate twoJdbcTemplate(@Qualifier("twoDataSource") DataSource datasource){
        return new JdbcTemplate(datasource);
    }

    @Bean("oneTransactionManager")
    public PlatformTransactionManager prodTransactionManager(@Qualifier("oneDataSource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }

    @Bean("twoTransactionManager")
    public PlatformTransactionManager devTransactionManager(@Qualifier("twoDataSource") DataSource sitDataSource) {
        return new DataSourceTransactionManager(sitDataSource);
    }



}

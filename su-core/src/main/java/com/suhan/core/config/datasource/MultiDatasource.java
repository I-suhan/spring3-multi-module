package com.suhan.core.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(proxyBeanMethods = false)
public class MultiDatasource {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "su.datasource.primary")
    public DataSourceProperties primaryDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("primaryDataSource")
    @Primary
    @ConfigurationProperties("su.datasource.primary.configuration")
    public HikariDataSource primaryDatasource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties("su.datasource.secondary")
    public HikariDataSource secondDatasource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


}

package com.suhan.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(proxyBeanMethods = false)
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.user")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.user.configuration")
    public HikariDataSource userDataSource(DataSourceProperties userDataSourceProperties) {
        return userDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.product")
    public HikariDataSource secondDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.product.configuration")
    public HikariDataSource productDataSource(DataSourceProperties productDataSourceProperties) {
        return productDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}

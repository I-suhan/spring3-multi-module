package com.suhan.core.config.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="secondaryEntityManagerFactory",
        transactionManagerRef="secondaryTransactionManager",
        basePackages= { "com.suhan.product.repository" })
public class SecondaryDatasourceConfig {

    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondaryDataSource;
    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(secondaryDataSource)
                .properties(vendorProperties)
                .packages("com.suhan.product.entity") //设置实体类所在位置
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    @Bean(name = "secondaryEntityManager")
    public EntityManager secondaryEntityManager(EntityManagerFactoryBuilder builder) {
        EntityManagerFactory factory = secondaryEntityManagerFactory(builder).getObject();
        assert factory != null;
        return factory.createEntityManager();
    }

    @Bean(name = "secondaryTransactionManager")
    PlatformTransactionManager secondaryTransactionManager(EntityManagerFactoryBuilder builder) {
        EntityManagerFactory factory = secondaryEntityManagerFactory(builder).getObject();
        assert factory != null;
        return new JpaTransactionManager(factory);
    }
}

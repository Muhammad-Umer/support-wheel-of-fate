package org.engineering.support.wheel.fate.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.isolation.IsolationSupportHibernateJpaDialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by umer on 4/2/2018.
 */
@Profile("!test")
@Configuration
public class DatasourceConfiguration {

    @Bean
    @Qualifier("dataSource")
    @Primary
    @ConfigurationProperties(prefix = "database-configs")
    public ComboPooledDataSource dataSource() {
        return new ComboPooledDataSource();
    }

    @Bean
    public IsolationSupportHibernateJpaDialect customJpaDialect() {
        IsolationSupportHibernateJpaDialect isolationSupportHibernateJpaDialect =
                new IsolationSupportHibernateJpaDialect();
        return isolationSupportHibernateJpaDialect;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jpaDialect", customJpaDialect());
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("org.engineering")
                .persistenceUnit("generalPersistenceUnit")
                .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager transactionManager(
            @Qualifier("entityManagerFactory")
                    EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}

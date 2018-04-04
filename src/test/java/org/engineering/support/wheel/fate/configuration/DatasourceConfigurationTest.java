package org.engineering.support.wheel.fate.configuration;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.isolation.IsolationSupportHibernateJpaDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by umer on 4/4/2018.
 */
@TestConfiguration
public class DatasourceConfigurationTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private IsolationSupportHibernateJpaDialect customJpaDialect;

    @Value("${spring.jpa.database}")
    private String generalDatabasePlatform;


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setPackagesToScan("org.engineering");
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(readReplicaHibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPersistenceUnitName("generalPersistenceUnit");
        entityManagerFactoryBean.setJpaDialect(customJpaDialect);
        entityManagerFactoryBean.setJpaProperties(getDefaultProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    @Primary
    public HibernateJpaVendorAdapter readReplicaHibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabasePlatform(generalDatabasePlatform);
        return hibernateJpaVendorAdapter;
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

    private Properties getDefaultProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.cache.region.factory_class",
                "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        jpaProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
        jpaProperties.setProperty("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");
        return jpaProperties;
    }
}

package org.engineering.support.wheel.fate.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by umer on 2/19/17.
 */
@TestConfiguration
public class BeanConfigurationTest {

    @Value("${datasource.database.endpoint}")
    private String jdbcUrl;

    @Value("${datasource.database.username}")
    private String username;

    @Value("${datasource.database.password}")
    private String password;

    @Value("${datasource.database.class-name}")
    private String driverName;

    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException, ClassNotFoundException {
        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .driverClassName(driverName)
                .build();
    }
}
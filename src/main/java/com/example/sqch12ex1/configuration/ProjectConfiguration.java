package com.example.sqch12ex1.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfiguration {

    @Value("${custom.datasource.url}")
    private String dataSourceUrl;

    @Value("${custom.datasource.username}")
    private String dataSourceUsername;

    @Value("${custom.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

}

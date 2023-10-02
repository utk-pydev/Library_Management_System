package com.example.MySqlTutorial.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories()
public class DBConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.authordatasource")
    public DataSource authorDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.persondatasource")
    public DataSource personDataSource(){
        return DataSourceBuilder.create().build();
    }
}

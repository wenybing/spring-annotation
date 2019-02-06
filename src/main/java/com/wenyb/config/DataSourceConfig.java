package com.wenyb.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author wenyabing
 * @Date 2019/1/24 15:50
 */
@Profile("dev")
@PropertySource("classpath:/dbConfig.properties")
@Configuration
public class DataSourceConfig {
    @Value("${db.userName}")
    private String userName;
    @Value("${db.password}")
    private String password;

    @Profile("test")
    @Bean(value = "testDataSource")
    public DataSource dataSourceTest() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:3306/test_01");
        return dataSource;
    }

    @Profile("dev")
    @Bean(value = "devDataSource")
    public DataSource dataSourceDev(@Value("${db.driverClass}") String driverClass) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql:3306/student");
        return dataSource;
    }

    @Profile("pro")
    @Bean(value = "proDataSource")
    public DataSource dataSourcePro() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql:3306/sell");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
}

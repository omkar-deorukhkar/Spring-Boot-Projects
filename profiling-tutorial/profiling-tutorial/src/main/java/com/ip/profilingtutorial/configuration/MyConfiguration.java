package com.ip.profilingtutorial.configuration;

import com.ip.profilingtutorial.beans.MyDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mydatasource.properties")
public class MyConfiguration {
    @Bean
    public MyDataSource getMyDataSourceBean(
            @Value("${mydatasource.username}") String username,
            @Value("${mydatasource.password}") String password){
        MyDataSource myDataSource = new MyDataSource();

        myDataSource.setUsername(username);
        myDataSource.setPassword(password);

        return myDataSource;
    }
}

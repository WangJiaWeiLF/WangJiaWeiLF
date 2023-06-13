package com.nowcoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sun.awt.SunHints;

import java.text.SimpleDateFormat;

@ComponentScan(value="com.nowcoder.dao")
@Configuration
public class TestConfig {

    @Bean
    public SimpleDateFormat get(){
        return new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
    }
}

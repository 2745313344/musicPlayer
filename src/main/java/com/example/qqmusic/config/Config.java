package com.example.qqmusic.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.example.qqmusic.handler.Filed;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@MapperScan("com.example.qqmusic")
public class Config {
@Bean
    public ISqlInjector sqlInjector(){return new LogicSqlInjector(); }
@Bean
    public PaginationInterceptor paginationInterceptor(){return new PaginationInterceptor();}
//    @Bean
//    public Filed filed(){
//    return new Filed();
//    }
}

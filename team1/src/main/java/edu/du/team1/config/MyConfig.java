package edu.du.team1.config;

import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan("edu.du.team1.mapper")
public class MyConfig {
}
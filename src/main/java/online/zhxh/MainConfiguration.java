package online.zhxh.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EntityScan("online.zhxh.vo")
@MapperScan("online.zhxh.mapper")
@ComponentScan(basePackages = "online.zhxh.controller", useDefaultFilters = false, includeFilters = {
        @ComponentScan.Filter(value = { Controller.class }) })
public class MainConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(MainConfiguration.class, args);
	}
}

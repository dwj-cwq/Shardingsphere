package com.dwj.springboot.mybatis;

import com.dwj.springboot.mybatis.service.OrderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

/**
 * @author Chen Wenqun
 */
@MapperScan(basePackages = "com.dwj.springboot.mybatis.repository")
@SpringBootApplication(exclude = {JtaAutoConfiguration.class})
public class Application {

    public static void main(final String[] args) throws SQLException {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args)) {
            final OrderService orderService = applicationContext.getBean(OrderService.class);
            orderService.initEnvironment();
            orderService.processSuccess();
            orderService.cleanEnvironment();
        }
    }
}

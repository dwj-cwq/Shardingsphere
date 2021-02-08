package com.dwj.springboot.jpa;

import com.dwj.springboot.jpa.service.OrderService;
import com.dwj.springboot.jpa.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Chen Wenqun
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, JtaAutoConfiguration.class})
public class Application {

    public static void main(String[] args) throws IOException, SQLException {
        SpringApplication.run(Application.class, args);
        final OrderService orderService = SpringContextUtil.getBeanClass(OrderService.class);
        orderService.initEnvironment();
        orderService.processSuccess();
        orderService.cleanEnvironment();
    }
}

package com.dwj.jdbc;

import com.dwj.jdbc.config.YamlConfig;
import com.dwj.jdbc.service.OrderService;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Chen Wenqun
 */
public class Application {

    public static void main(String[] args) throws IOException, SQLException {
        DataSource dataSource = YamlConfig.initDataSource();
        execute(dataSource);
    }

    public static void execute(DataSource dataSource) throws IOException, SQLException {
        OrderService orderService = YamlConfig.getExampleService(dataSource);
        orderService.initEnvironment();
        orderService.processSuccess();
        orderService.printData();
        orderService.cleanEnvironment();
    }
}

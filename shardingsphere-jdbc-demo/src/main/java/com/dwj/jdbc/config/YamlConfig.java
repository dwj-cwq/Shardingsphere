package com.dwj.jdbc.config;

import com.dwj.jdbc.constant.ShardingType;
import com.dwj.jdbc.factory.YamlDataSourceFactory;
import com.dwj.jdbc.service.OrderService;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Chen Wenqun
 */
public class YamlConfig {

    private static ShardingType shardingType = ShardingType.SHARDING_DATABASES;
//    private static ShardingType shardingType = ShardingType.SHARDING_TABLES;
//    private static ShardingType shardingType = ShardingType.SHARDING_DATABASES_AND_TABLES;
//    private static ShardingType shardingType = ShardingType.REPLICA_QUERY;
//    private static ShardingType shardingType = ShardingType.SHARDING_REPLICA_QUERY;

    public static DataSource initDataSource() throws SQLException, IOException {
        return YamlDataSourceFactory.newInstance(shardingType);
    }

    public static OrderService getExampleService(final DataSource dataSource) {
        return new OrderService(dataSource);
    }
}

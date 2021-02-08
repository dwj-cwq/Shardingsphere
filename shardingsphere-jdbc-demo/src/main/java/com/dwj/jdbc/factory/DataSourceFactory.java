package com.dwj.jdbc.factory;

import com.dwj.jdbc.constant.ShardingType;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Chen Wenqun
 */
public class DataSourceFactory {

    public DataSource newInstance(final ShardingType shardingType) throws SQLException, IOException {
//        switch (shardingType) {
//            case SHARDING_DATABASES:
//                return new ShardingDatabasesConfigurationPrecise().getDataSource();
//            case SHARDING_TABLES:
//                return new ShardingTablesConfigurationPrecise().getDataSource();
//            case SHARDING_DATABASES_AND_TABLES:
//                return new ShardingDatabasesAndTablesConfigurationPrecise().getDataSource();
//            case REPLICA_QUERY:
//                return new ReplicaQueryConfiguration().getDataSource();
//            case SHARDING_REPLICA_QUERY:
//                return new ShardingReplicaQueryConfigurationPrecise().getDataSource();
//            default:
//                throw new UnsupportedOperationException(shardingType.name());
//        }
        return null;
    }

}

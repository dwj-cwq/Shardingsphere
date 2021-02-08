package com.dwj.jdbc.factory;

import com.dwj.jdbc.constant.ShardingType;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Chen Wenqun
 */
public class YamlDataSourceFactory {

    private static final String PREFIX = "/Users/dwj/Sourcetree/myProject/ShardingSphere/shardingsphere-jdbc-demo/src/main/resources/";

    public static DataSource newInstance(final ShardingType shardingType) throws SQLException, IOException {
        switch (shardingType) {
            case SHARDING_DATABASES:
                return YamlShardingSphereDataSourceFactory.createDataSource(getFile("sharding-databases.yaml"));
            case SHARDING_TABLES:
                return YamlShardingSphereDataSourceFactory.createDataSource(getFile("sharding-tables.yaml"));
            case SHARDING_DATABASES_AND_TABLES:
                return YamlShardingSphereDataSourceFactory.createDataSource(getFile("sharding-databases-tables.yaml"));
            case REPLICA_QUERY:
                return YamlShardingSphereDataSourceFactory.createDataSource(getFile("replica-query.yaml"));
            case SHARDING_REPLICA_QUERY:
                return YamlShardingSphereDataSourceFactory.createDataSource(getFile("sharding-replica-query.yaml"));
            default:
                throw new UnsupportedOperationException(shardingType.name());
        }
    }

    private static File getFile(final String fileName) {
        return new File(PREFIX + fileName);
    }
}

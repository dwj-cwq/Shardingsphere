package com.dwj.jdbc.repository;

import com.dwj.jdbc.entity.Address;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chen Wenqun
 */
public class AddressRepository {

    private final DataSource dataSource;

    public AddressRepository(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS t_address "
            + "(address_id BIGINT NOT NULL, address_name VARCHAR(100) NOT NULL, PRIMARY KEY (address_id))";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    public void dropTable() throws SQLException {
        String sql = "DROP TABLE t_address";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    public void truncateTable() throws SQLException {
        String sql = "TRUNCATE TABLE t_address";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    public Long insert(final Address entity) throws SQLException {
        String sql = "INSERT INTO t_address (address_id, address_name) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, entity.getAddressId());
            preparedStatement.setString(2, entity.getAddressName());
            preparedStatement.executeUpdate();
        }
        return entity.getAddressId();
    }

    public void delete(final Long primaryKey) throws SQLException {
        String sql = "DELETE FROM t_address WHERE address_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, primaryKey);
            preparedStatement.executeUpdate();
        }
    }

    public List<Address> selectAll() throws SQLException {
        String sql = "SELECT * FROM t_address";
        return getAddress(sql);
    }

    private List<Address> getAddress(final String sql) throws SQLException {
        List<Address> result = new LinkedList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Address address = new Address();
                address.setAddressId(resultSet.getLong(1));
                address.setAddressName(resultSet.getString(2));
                result.add(address);
            }
        }
        return result;
    }
}
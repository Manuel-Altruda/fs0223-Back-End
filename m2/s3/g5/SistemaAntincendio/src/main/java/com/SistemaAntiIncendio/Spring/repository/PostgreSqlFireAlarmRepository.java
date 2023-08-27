package com.SistemaAntiIncendio.Spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public abstract class PostgreSqlFireAlarmRepository implements FireAlarmRepository {
	private String jdbcUrl;
    private String username;
    private String password;
    
    public PostgreSqlFireAlarmRepository(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }
    
    public void saveAlarmData(String idSonda, double latitude, double longitude, double smokeLevel) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "INSERT INTO alarms (id_sonda, latitude, longitude, smoke_level) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idSonda);
            statement.setDouble(2, latitude);
            statement.setDouble(3, longitude);
            statement.setDouble(4, smokeLevel);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

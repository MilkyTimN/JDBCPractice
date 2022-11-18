package dao.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {

    @Override
    public PreparedStatement getStatement(String sql) {
        try ( Connection connection = DriverManager.getConnection("jdbc:postgres://localhost:5432/Shop_DB",
                "postgres", "1006")){
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new SqlException("Error connecting to DB");
        }
    }
}

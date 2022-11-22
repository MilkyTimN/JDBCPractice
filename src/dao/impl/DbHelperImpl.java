package dao.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {

    @Override
    public PreparedStatement getStatement(String sql) throws SQLException{

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
                "postgres", "1006");
        return connection.prepareStatement(sql);



//        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
//                "postgres", "1006")){
//            return connection.prepareStatement(sql);
//        } catch (SQLException e) {
//            throw new SqlException("Error connecting to DB");
//        }
    }
}

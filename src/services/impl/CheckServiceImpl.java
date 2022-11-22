package services.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;
import dao.impl.DbHelperImpl;
import models.Check;
import models.Shop;
import services.CheckService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    DbHelper dbHelper = new DbHelperImpl();
    @Override
    public void save(Check check) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("INSERT INTO tb_check(add_date, total_sum) values(?,?)")) {

            preparedStatement.setString(1, check.getAddDate().toString());
            preparedStatement.setDouble(2, check.getTotalSum());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            //throw new SqlException("Error to save shop into DB");
            SqlException.printSQLException(e);
        }
    }

    @Override
    public void update(Check check) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_check SET total_sum =? WHERE id =?")) {

            preparedStatement.setDouble(1, check.getTotalSum());
            preparedStatement.setLong(2, check.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new SqlException("Error to update shop to DB");
        }
    }

    @Override
    public List<Check> findAll() {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_check")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Check>checkList = new ArrayList<>();
            while (resultSet.next()){
                Check check = new Check();

                check.setId(resultSet.getLong("id"));
                check.setAddDate(resultSet.getDate("add_date"));
                check.setTotalSum(resultSet.getDouble("total_sum"));

                checkList.add(check);

            } return checkList;

        } catch (SQLException e) {
            throw new SqlException("Error to output shop form data");
        }
    }

    @Override
    public Check findById(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FORM tb_check WHERE id =?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Check check = new Check();
            while (resultSet.next()){

                check.setId(resultSet.getLong("id"));
                check.setAddDate(resultSet.getDate("add_date"));
                check.setTotalSum(resultSet.getDouble("total_sum"));


            } return check;
            } catch(SQLException e){
                throw new SqlException("Error to output shop form data");
            }
    }

    @Override
    public void delete(Long id) {

    }
}

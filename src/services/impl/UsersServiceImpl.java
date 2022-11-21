package services.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;
import dao.impl.DbHelperImpl;
import models.Shop;
import models.Users;
import services.ShopServices;
import services.UsersService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UsersServiceImpl implements UsersService {
    DbHelper dbHelper = new DbHelperImpl();
    ShopServices shopServices = new ShopServicesImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Users user) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("INSERT tb_users SET (name, login, password, active, add_date, id_tb_shop) VALUES (?,?,?,?,?,?)")) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setBoolean(4, user.isActive());
            preparedStatement.setString(5, new Date().toString());
            preparedStatement.setLong(6, user.getShopId().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to save user");
        }
    }

    @Override
    public void update(Users user) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_users SET(name, login, password, id_tb_shop) VALUES (?,?,?,?)")) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, user.getShopId().getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            throw new SqlException("Error to update user");
        }

    }

    @Override
    public List<Users> findAll() {

        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT" +
                        " * FROM tb_users WHERE active =?")) {
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Users> usersList = new ArrayList<>();
            while (resultSet.next()){
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setShopId(shopServices.findById(user.getShopId().getId()));

                usersList.add(user);
            } return usersList;

        } catch (SQLException e) {
            throw new SqlException("Error to find all users");
        }
    }

    @Override
    public Users findById(Long id) {

        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_users WHERE id =?")){

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users user = new Users();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setShopId(shopServices.findById(user.getShopId().getId()));
                user.setAddDate(resultSet.getDate("add_date"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            } return user;

        } catch (SQLException e) {
            throw new SqlException("Error to find users by id");
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_users SET active = ? WHERE id =?")) {
            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new SqlException("Error to delete user");
        }
    }

    public void create() {
        System.out.println("Напишите название магазина ");

        Users user = new Users();
        user.setName(scanner.next());

        save(user);
    }
}

package services.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;
import dao.impl.DbHelperImpl;
import models.Shop;
import services.ShopServices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShopServicesImpl implements ShopServices {

    DbHelper dbHelper = new DbHelperImpl();

    @Override
    public void save(Shop shop) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("INSERT INTO tb_shop(name, add_date, active) values(?,?,?)")) {

            preparedStatement.setString(1, shop.getName());
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setBoolean(3, true);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            //throw new SqlException("Error to save shop into DB");
            SqlException.printSQLException(e);
        }
    }

    @Override
    public void update(Shop shop) {

        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_shop SET name =? WHERE id =?")) {

            preparedStatement.setString(1, shop.getName());
            preparedStatement.setLong(2, shop.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new SqlException("Error to update shop to DB");
        }
    }

    @Override
    public List<Shop> findAll() {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_shop WHERE active =?")) {
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Shop>shopList = new ArrayList<>();
            while (resultSet.next()){
                Shop shop = new Shop();

                shop.setId(resultSet.getLong("id"));
                shop.setName(resultSet.getString("name"));
                shop.setActive(resultSet.getBoolean("active"));
                shop.setAddDate(resultSet.getString("add_date"));

                shopList.add(shop);

            } return shopList;

        } catch (SQLException e) {
            throw new SqlException("Error to output shop form data");
        }
    }

    public List<Shop> findAllIdName() {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_shop WHERE active =?")) {
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Shop>shopList = new ArrayList<>();
            while (resultSet.next()){
                Shop shop = new Shop();

                shop.setId(resultSet.getLong("id"));
                shop.setName(resultSet.getString("name"));

                shopList.add(shop);

            } return shopList;

        } catch (SQLException e) {
            throw new SqlException("Error to output shop form data");
        }
    }

    @Override
    public Shop findById(Long id) {

        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_shop WHERE id =?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Shop shop = new Shop();
            while (resultSet.next()){
                shop.setId(resultSet.getLong("id"));
                shop.setName(resultSet.getString("name"));
                shop.setActive(resultSet.getBoolean("active"));
                shop.setAddDate(resultSet.getString("add_date"));


            } return shop;


        } catch (SQLException e) {
            throw new SqlException("Error to output shop by id");
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_shop SET active = ? WHERE id =?")){
            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to delete shop");
        }
    }

}

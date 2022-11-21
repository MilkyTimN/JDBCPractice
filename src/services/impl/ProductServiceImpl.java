package services.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;
import dao.impl.DbHelperImpl;
import models.Product;
import models.Shop;
import services.CategoryService;
import services.ProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {

    DbHelper dbHelper = new DbHelperImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Product product) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("INSERT INTO tb_product(add_date, name, price, id_tb_categories, discount) VALUES (?,?,?,?,?)")){

            preparedStatement.setString(1, new Date().toString());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setLong(4, product.getCategoryId().getId());
            preparedStatement.setInt(5, product.getDiscount());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to save product");
        }
    }

    @Override
    public void update(Product product) {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_product SET (name, price, id_tb_categories, discount) VALUES (?,?,?,?)")){

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setLong(3, product.getCategoryId().getId());
            preparedStatement.setInt(4, product.getDiscount());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to update product");
        }

    }

    @Override
    public List<Product> findAll() {
        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_product WHERE active =?")){
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {

                Product product = new Product();

                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(categoryService.findById(product.getCategoryId().getId()));
                product.setPrice(resultSet.getDouble("price"));
                product.setDiscount(resultSet.getInt("discount"));

                productList.add(product);

            } return productList;

        } catch (SQLException e) {
            throw new SqlException("Error to find all from product");
        }
    }

    @Override
    public Product findById(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM Product WHERE id = ?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = new Product();

            while (resultSet.next()) {
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setCategoryId(categoryService.findById(product.getCategoryId().getId()));
                product.setPrice(resultSet.getDouble("price"));
                product.setDiscount(resultSet.getInt("discount"));

            } return product;

        } catch (SQLException e) {
            throw new SqlException("Error to find product by id");
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_product SET active = ? WHERE id = ?")){

            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to delete product");
        }
    }
}

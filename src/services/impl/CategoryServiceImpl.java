package services.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;
import dao.impl.DbHelperImpl;
import models.Categories;
import models.Shop;
import services.CategoryService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CategoryServiceImpl implements CategoryService {

    DbHelper dbHelper = new DbHelperImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Categories categories) {
        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("INSERT INTO tb_category(name, add_date, active) values(?,?,?)")) {

            preparedStatement.setString(1, categories.getName());
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setBoolean(3, true);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to save category into DB");
        }
    }

    @Override
    public void update(Categories categories) {

        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_categories SET name =? WHERE id =?")) {

            preparedStatement.setString(1, categories.getName());
            preparedStatement.setLong(2, categories.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            throw new SqlException("Error to update category to DB");
        }

    }

    @Override
    public List<Categories> findAll() {

        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FROM tb_category WHERE active =?")) {
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Categories>categoriesList = new ArrayList<>();
            while (resultSet.next()){
                Categories categories = new Categories();

                categories.setId(resultSet.getLong("id"));
                categories.setName(resultSet.getString("name"));
                categories.setActive(resultSet.getBoolean("active"));
                categories.setAddDate(resultSet.getDate("add_date"));

                categoriesList.add(categories);

            } return categoriesList;

        } catch (SQLException e) {
            throw new SqlException("Error to output category form data");
        }
    }

    @Override
    public Categories findById(Long id) {

        try (PreparedStatement preparedStatement = dbHelper.getStatement
                ("SELECT * FORM tb_categories WHERE id =?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Categories categories = new Categories();

            while (resultSet.next()) {
                categories.setId(resultSet.getLong("id"));
                categories.setName(resultSet.getString("name"));
                categories.setActive(resultSet.getBoolean("active"));
                categories.setAddDate(resultSet.getDate("add_date"));

            } return categories;


        } catch (SQLException e) {
            throw new SqlException("Error to output category by id");
        }
    }

    @Override
    public void delete(Long id) {

        try(PreparedStatement preparedStatement = dbHelper.getStatement
                ("UPDATE tb_category SET active = ? WHERE id =?")){
            preparedStatement.setBoolean(1, false);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to delete category");
        }
    }
}

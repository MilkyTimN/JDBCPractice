package services.impl;

import dao.DbHelper;
import dao.exceptions.SqlException;
import dao.impl.DbHelperImpl;
import models.CheckProduct;
import services.CheckProductService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CheckProductServiceImpl implements CheckProductService {

    DbHelper dbHelper = new DbHelperImpl();


    @Override
    public void save(CheckProduct checkProduct) {

    }

    @Override
    public void update(CheckProduct checkProduct) {

    }

    @Override
    public List<CheckProduct> findAll() {
        return null;
    }

    @Override
    public CheckProduct findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

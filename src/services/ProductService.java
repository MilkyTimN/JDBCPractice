package services;

import models.Product;

import java.util.List;

public interface ProductService extends BaseEntity<Product>{
    @Override
    void save(Product product);

    @Override
    void update(Product product);

    @Override
    List<Product> findAll();

    @Override
    Product findById(Long id);

    @Override
    void delete(Long id);

}

package services;

import models.Categories;

import java.util.List;

public interface CategoryService extends BaseEntity<Categories>{
    @Override
    void save(Categories categories);

    @Override
    void update(Categories categories);

    @Override
    List<Categories> findAll();

    @Override
    Categories findById(Long id);

    @Override
    void delete(Long id);
}

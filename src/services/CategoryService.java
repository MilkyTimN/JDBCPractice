package services;

import models.Categories;

import java.util.List;

public interface CategoryService extends BaseEntity<Categories>{
    @Override
    default void save(Categories categories) {

    }

    @Override
    default void update(Categories categories) {

    }

    @Override
    default List<Categories> findAll() {
        return null;
    }

    @Override
    default Categories findById(Long id) {
        return null;
    }

    @Override
    default void delete(Long id) {

    }
}

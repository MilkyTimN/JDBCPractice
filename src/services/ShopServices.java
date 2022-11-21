package services;

import models.Shop;

import java.util.List;

public interface ShopServices extends BaseEntity<Shop> {

    @Override
    void save(Shop shop);

    @Override
    void update(Shop shop);

    @Override
    List<Shop> findAll();

    @Override
    Shop findById(Long id);

    @Override
    void delete(Long id);

}

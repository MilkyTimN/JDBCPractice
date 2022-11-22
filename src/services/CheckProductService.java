package services;

import models.CheckProduct;

import java.util.List;

public interface CheckProductService extends BaseEntity<CheckProduct>{

    @Override
    void save(CheckProduct checkProduct);

    @Override
    void update(CheckProduct checkProduct);

    @Override
    List<CheckProduct> findAll();

    @Override
    CheckProduct findById(Long id);

    @Override
    void delete(Long id);
}

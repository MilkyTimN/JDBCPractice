package services;

import models.Check;

import java.util.List;

public interface CheckService extends BaseEntity<Check>{
    @Override
    void save(Check check);

    @Override
    void update(Check check);

    @Override
    List<Check> findAll();

    @Override
    Check findById(Long id);

    @Override
    void delete(Long id);
}

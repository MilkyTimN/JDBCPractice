package services;

import models.Users;

import java.util.List;

public interface UsersService extends BaseEntity<Users>{
    @Override
    void save(Users users);

    @Override
    void update(Users users);

    @Override
    List<Users> findAll();

    @Override
    Users findById(Long id);

    @Override
    void delete(Long id);
}

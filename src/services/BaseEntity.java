package services;

import java.util.List;

public interface BaseEntity<T> {
    void save(T t);
    void update(T t);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
}

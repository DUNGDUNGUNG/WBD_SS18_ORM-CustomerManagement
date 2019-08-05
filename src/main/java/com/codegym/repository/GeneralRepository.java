package com.codegym.repository;

import java.util.List;

public interface GeneralRepository<T> {
    List<T>findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);

    void update(T model);
}

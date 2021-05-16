package com.max.restApp.repostories;

import java.util.List;

public interface GenericRepository <T>{
    T save(T object);
    T update(T object);
    T getById(Integer id);
    List<T> getAll();
    void deleteById(Integer id);
}

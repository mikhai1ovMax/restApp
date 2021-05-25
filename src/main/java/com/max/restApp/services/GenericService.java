package com.max.restApp.services;

import java.util.List;

public interface GenericService<T> {
    public List<T> getAll();
    public T save(T object);
    public T update(T object);
    T getById(Integer id);
    public void deleteById(int id);
}

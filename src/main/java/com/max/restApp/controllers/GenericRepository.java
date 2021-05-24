package com.max.restApp.controllers;

import java.util.List;

public interface GenericRepository<T> {
    public List<T> getAll();
    public T save(T object);
    public T update(T object);
    public void deleteById(int id);
}

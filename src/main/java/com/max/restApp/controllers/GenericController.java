package com.max.restApp.controllers;

import java.util.List;

public interface GenericController<T> {
    public List<T> getAll();
    public T save(T object);
    public T update(T object);
    T getById(Integer id);
    public void deleteById(int id);
}

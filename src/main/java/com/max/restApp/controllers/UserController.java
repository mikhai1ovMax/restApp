package com.max.restApp.controllers;

import com.max.restApp.models.User;
import com.max.restApp.services.UserService;

import java.util.List;

public class UserController implements GenericController<User> {
    UserService service;

    public UserController() {
        service = new UserService();
    }

    @Override
    public List<User> getAll() {
        return service.getAll();
    }

    @Override
    public User save(User object) {
        return service.save(object);
    }

    @Override
    public User update(User object) {
        return service.update(object);
    }

    @Override
    public User getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);

    }


}

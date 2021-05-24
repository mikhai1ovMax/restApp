package com.max.restApp.services;

import com.max.restApp.models.User;
import com.max.restApp.repostories.UserRepository;

import java.util.List;

public class UserService implements GenericService<User> {
    UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User save(User object) {
        return repository.save(object);
    }

    @Override
    public User update(User object) {
        return repository.save(object);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

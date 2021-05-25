package com.max.restApp.services;

import com.max.restApp.models.Account;
import com.max.restApp.repostories.AccountRepository;

import java.util.List;

public class AccountService implements GenericService<Account> {
    AccountRepository repository;

    public AccountService() {
        repository = new AccountRepository();
    }

    @Override
    public List<Account> getAll() {
        return repository.getAll();
    }

    @Override
    public Account save(Account object) {
        return repository.save(object);
    }

    @Override
    public Account update(Account object) {
        return repository.update(object);
    }

    @Override
    public Account getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

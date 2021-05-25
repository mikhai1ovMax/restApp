package com.max.restApp.controllers;

import com.max.restApp.models.Account;
import com.max.restApp.services.AccountService;

import java.util.List;

public class AccountController implements GenericController<Account> {
    AccountService service;

    public AccountController() {
        service = new AccountService();
    }

    @Override
    public List<Account> getAll() {
        return service.getAll();
    }

    @Override
    public Account save(Account object) {
        return service.save(object);
    }

    @Override
    public Account update(Account object) {
        return service.update(object);
    }

    @Override
    public Account getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}

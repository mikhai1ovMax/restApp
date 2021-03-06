package com.max.restApp.controllers;

import com.max.restApp.models.File;
import com.max.restApp.services.FileService;

import java.util.List;

public class FileController implements GenericController<File> {
    FileService service;

    public FileController() {
        service = new FileService();
    }

    @Override
    public List<File> getAll() {
        return service.getAll();
    }

    @Override
    public File save(File object) {
        return service.save(object);
    }

    @Override
    public File update(File object) {
        return service.update(object);
    }

    @Override
    public File getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);

    }
}

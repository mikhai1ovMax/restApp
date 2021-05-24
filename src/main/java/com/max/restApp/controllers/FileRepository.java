package com.max.restApp.controllers;

import com.max.restApp.models.File;
import com.max.restApp.services.FileService;

import java.util.List;

public class FileRepository implements GenericRepository<File> {
    FileService service;

    public FileRepository() {
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
    public void deleteById(int id) {
        service.deleteById(id);

    }
}

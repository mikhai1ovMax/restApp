package com.max.restApp.services;

import com.max.restApp.models.File;
import com.max.restApp.repostories.FileRepository;

import java.util.List;

public class FileService implements GenericService<File>{
    FileRepository repository;

    public FileService() {
        repository = new FileRepository();
    }

    @Override
    public List<File> getAll() {
        return repository.getAll();    }

    @Override
    public File save(File object) {
        return repository.save(object);
    }

    @Override
    public File update(File object) {
        return repository.save(object);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }
}

package com.max.restApp.services;

import com.max.restApp.models.Event;
import com.max.restApp.repostories.EventRepository;

import java.util.List;

public class EventService implements GenericService<Event> {
    EventRepository repository;

    public EventService() {
        repository = new EventRepository();
    }

    @Override
    public List<Event> getAll() {
        return repository.getAll();
    }

    @Override
    public Event save(Event object) {
        return repository.save(object);    }

    @Override
    public Event update(Event object) {
        return repository.update(object);    }

    @Override
    public Event getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}

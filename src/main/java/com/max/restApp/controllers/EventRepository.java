package com.max.restApp.controllers;

import com.max.restApp.models.Event;
import com.max.restApp.services.EventService;

import java.util.List;

public class EventRepository implements GenericRepository<Event> {
    EventService service;

    public EventRepository() {
        service = new EventService();
    }

    @Override
    public List<Event> getAll() {
        return service.getAll();
    }

    @Override
    public Event save(Event object) {
        return service.save(object);
    }

    @Override
    public Event update(Event object) {
        return service.update(object);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}

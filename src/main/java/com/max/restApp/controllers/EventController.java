package com.max.restApp.controllers;

import com.max.restApp.models.Event;
import com.max.restApp.services.EventService;

import java.util.List;

public class EventController implements GenericController<Event> {
    EventService service;

    public EventController() {
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
    public Event getById(Integer id) {
        return service.getById(id);
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}

package com.cinebokk.service;

import java.util.List;

import com.cinebokk.entity.Event;

public interface EventService {

	Event create(Event event);

	List<Event> getAll();

	Event update(Long id, Event event);

	void delete(Long id);

}
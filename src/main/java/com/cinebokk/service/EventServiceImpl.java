package com.cinebokk.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cinebokk.entity.Event;
import com.cinebokk.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	private final EventRepository repository;

	public EventServiceImpl(EventRepository repository) {

		this.repository = repository;

	}

	@Override
	public Event create(Event event) {

		return repository.save(event);

	}

	@Override
	public List<Event> getAll() {

		return repository.findAll();

	}

	@Override
	public Event update(
			Long id,
			Event event
	){

		Event old = repository.findById(id).orElseThrow();

		old.setTitle(
				event.getTitle()
		);

		old.setCategory(
				event.getCategory()
		);

		old.setDate(
				event.getDate()
		);

		old.setLocation(
				event.getLocation()
		);

		old.setPrice(
				event.getPrice()
		);

		old.setImage(
				event.getImage()
		);

		return repository.save(
				old
		);

	}

	@Override
	public void delete(Long id) {

		repository.deleteById(id);

	}

}
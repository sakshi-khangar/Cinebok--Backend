package com.cinebokk.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cinebokk.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
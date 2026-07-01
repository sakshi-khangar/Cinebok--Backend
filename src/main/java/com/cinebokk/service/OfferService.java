package com.cinebokk.service;

import java.util.List;

import com.cinebokk.entity.Offer;

public interface OfferService {

	Offer create(Offer offer);

	List<Offer> getAll();

	Offer update(Long id, Offer offer);

	void delete(Long id);

}
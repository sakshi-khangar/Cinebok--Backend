package com.cinebokk.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.cinebokk.entity.Offer;
import com.cinebokk.repository.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

	private final OfferRepository repository;

	public OfferServiceImpl(OfferRepository repository) {

		this.repository = repository;

	}

	@Override
	public Offer create(Offer offer) {

		return repository.save(offer);

	}

	@Override
	public List<Offer> getAll() {

		return repository.findAll();

	}

	@Override
	public Offer update(Long id, Offer offer) {

		Offer old =

				repository.findById(id).orElseThrow();

		old.setTitle(offer.getTitle());

		old.setCode(offer.getCode());

		old.setDiscount(offer.getDiscount());

		old.setExpiry(offer.getExpiry());

		old.setColor(offer.getColor());

		return repository.save(old);

	}

	@Override
	public void delete(Long id) {

		repository.deleteById(id);

	}

}
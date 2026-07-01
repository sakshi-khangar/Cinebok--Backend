package com.cinebokk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinebokk.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}